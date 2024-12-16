package javaproject.server.services;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import javaproject.server.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    @Value("${key.SECRET_KEY}")
    private String SECRET_KEY;

    /*
    Header:
    - type of token ("typ"): jwt
    - algorithm ("alg"): HS512
    */

    /*
    PayLoad: /Claims/
    - subject ("sub"): userID
    - issuer ("iss"): hcmus.com
    - other -> extraClaims ("role"): true if user has role admin and opposite
    - issued at ("iat"): when user get sign in or sign up
    - expiration at ("exp"): 4 * 60m * 60s * 1000ms = 4 hours
    */

    /*
    Signature:
    - Key: system secret key (base64)
    */

    // Nimbus lib
    public String generateToken(User user)
    {
        //Header
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        //Claims
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getId())
                .issuer("hcmus.com")
                .issueTime(new Date(System.currentTimeMillis()))
                .expirationTime(new Date(System.currentTimeMillis() + 4*60*60*1000))
                .claim("rol",user.getRole().toUpperCase())
                .build();

        //Payload
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header,payload);

        try {
            jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

        private JwtDecoder JwtDecoder()
    {
        //Create object decode
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(),"HS512");
        return NimbusJwtDecoder
                .withSecretKey(secretKeySpec)
                .macAlgorithm(MacAlgorithm.HS512)
                .build();
    }


    public boolean isValidToken(String token)
    {
        // Not expire
        return !isExpiredToken(token);
    }


    public String getRole(String token)
    {
        Jwt jwt = JwtDecoder().decode(token);
        Map<String,Object> claims = jwt.getClaims();
        return claims.get("rol").toString();
    }

    public String getUserID(String token)
    {
        Jwt jwt = JwtDecoder().decode(token);
        Map<String,Object> claims = jwt.getClaims();
        return claims.get("sub").toString();
    }

    private boolean isExpiredToken(String token) {
        //Check expire day
        //Jwt object include Map<String,Object> Header and Claims
        Jwt jwt = JwtDecoder().decode(token);

        Date expirationDate = getExpireDay(jwt);
        // Check expiration day is before (true) or after (false) current Date
        return expirationDate.before(new Date());
    }

    private Date getExpireDay(Jwt jwt)
    {
        Map<String,Object> claims = jwt.getClaims();
        return Date.from((Instant) claims.get("exp"));
    }


//    public Map<String, Object> extractAllClaims(String token) {
//        try {
//            Jwt jwt = JwtDecoder().decode(token);
//            return jwt.getClaims();//Return Map Claims
//        } catch (Exception e) {
//            throw new RuntimeException("Invalid token", e);
//        }
//    }

//    public String extractUserID(String token) {
//        try {
//            return extractAllClaims(token).get("sub").toString(); //Return UserId from claims
//        } catch (Exception e) {
//            throw new RuntimeException("Cannot extract user ID", e);
//        }
//    }

//        public boolean isValidToken(String token, UserDetails userDetails){
//        // If the token belongs to userDetails ?
//        final String userID = extractUserID(token);
//        // If userId in token  == userId get from Database
//            //and token is NOT expired
//        return (userID.equals(userDetails.getUsername())) && !isExpiredToken(token);
//    }

//    private Date extractExpiredDate(String token) {
//        try {
//            // Get all claims from token
//            Map<String, Object> claims = extractAllClaims(token);
//            // Get exp from claims and convert to Date through Instant type
//            return Date.from((Instant) claims.get("exp"));
//        } catch (Exception e) {
//            throw new RuntimeException("Cannot extract expiration date", e);
//        }
//    }

}
