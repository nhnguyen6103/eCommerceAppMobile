package dev.services;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import dev.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
public class JwtService {

    public JwtService() {
    }

    @Value("${key.SECRET_KEY}")
    private String SECRET_KEY;

    /*
    Header:
    - type of token ("typ"): jwt
    - algorithm ("alg"): HS512
    */

    /*
    PayLoad:
    - subject ("sub"): userID
    - issuer ("iss"): hcmus.com
    - other -> extraClaims ("role"): true if user has role admin and opposite
    - issued at ("iat"): when user get sign in or sign up
    - expiration at ("exp"): 2 * 60m * 60s * 1000ms = 2 hours
    */

    /*
    Signature:
    - Key: system secret key (base64)
    */

    public String generateToken(User user)
    {
        //Header
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        //Claims
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getId())
                .issuer("hcmus.com")
                .issueTime(new Date(System.currentTimeMillis()))
                .expirationTime(new Date(System.currentTimeMillis() + 2*60*60*1000))
                .claim("role",user.getRole().toUpperCase())
                .build();

        //Payload
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header,payload);

        try {
            jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Cannot create token",e);
            throw new RuntimeException(e);
        }
    }

    public Map<String, Object> extractAllClaims(String token) {
        try {
            Jwt jwt = jwtDecoder().decode(token);
            return jwt.getClaims();//Return Map Claims
        } catch (Exception e) {
            log.error("Cannot decode token", e);
            throw new RuntimeException("Invalid token", e);
        }
    }

    public String extractUserID(String token) {
        try {
            return extractAllClaims(token).get("sub").toString(); //Return UserId from claims
        } catch (Exception e) {
            log.error("Cannot extract user ID from token", e);
            throw new RuntimeException("Cannot extract user ID", e);
        }
    }

        public boolean isValidToken(String token, UserDetails userDetails){
        // If the token belongs to userDetails ?
        final String userID = extractUserID(token);
        // If userId in token  == userId get from Database
            //and token is NOT expired
        return (userID.equals(userDetails.getUsername())) && !isExpiredToken(token);
    }

    private Date extractExpiredDate(String token) {
        try {
            // Get all claims from token
            Map<String, Object> claims = extractAllClaims(token);
            // Get exp from claims and convert to Date through Instant type
            return Date.from((Instant) claims.get("exp"));
        } catch (Exception e) {
            log.error("Cannot extract expiration date from token", e);
            throw new RuntimeException("Cannot extract expiration date", e);
        }
    }

    public boolean isExpiredToken(String token) {
        Date expirationDate = extractExpiredDate(token);
        // Check expiration day is before (true) or after (false) current Date
        return expirationDate.before(new Date());
    }

    private JwtDecoder jwtDecoder()
    {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(),"HS512");
        return NimbusJwtDecoder
                .withSecretKey(secretKeySpec)
                .macAlgorithm(MacAlgorithm.HS512)
                .build();
    }

}
