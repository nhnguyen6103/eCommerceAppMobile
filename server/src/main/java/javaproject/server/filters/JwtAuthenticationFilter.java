package javaproject.server.filters;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaproject.server.dtos.responses.ApiResponse;
import javaproject.server.exception.AppException;
import javaproject.server.exception.ErrorCode;
import javaproject.server.services.JwtService;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws IOException{

        try{
            if(isBypassToken(request)) //Check bypass Endpoint
            {
                //true
                filterChain.doFilter(request,response);
                return;
            }

            //get request Header = Authorization: Auth Type + Token
            String authHeader = request.getHeader("Authorization");


            if(authHeader == null || !authHeader.startsWith("Bearer ")) // null header or different auth type
            {
                sendErrorResponse(response, new AppException(ErrorCode.INVALID_REQUEST).getApiResponse());
                return;
            }

            final String jwtToken = authHeader.substring(7);
            if(!jwtService.isValidToken(jwtToken))
            {
                sendErrorResponse(response, new AppException(ErrorCode.INVALID_REQUEST).getApiResponse());
                return;
            }

            final String requestUserID = jwtService.getUserID(jwtToken);
            request.setAttribute("userID",requestUserID);

            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + jwtService.getRole(jwtToken).toUpperCase());
            // Tạo Authentication
            Authentication auth = new UsernamePasswordAuthenticationToken(null, null, List.of(authority));

            // Đặt Authentication vào SecurityContext
            SecurityContextHolder.getContext().setAuthentication(auth);

             filterChain.doFilter(request,response);

        } catch (AppException e) {
            sendErrorResponse(response, e.getApiResponse());
        } catch (Exception e) {
            sendErrorResponse(response, new AppException(ErrorCode.INVALID_REQUEST).getApiResponse());
        }
    }

    //Check token is bypass or not
    private boolean isBypassToken(HttpServletRequest request) {
        final Map<String, String> bypassToken = new HashMap<>();
        bypassToken.put("/user", "POST");
        bypassToken.put("/auth/signin", "POST");
        bypassToken.put("/product","GET");
        bypassToken.put("/category","GET");

        // Get request Endpoint and Method
        String requestPath = request.getServletPath();
        String requestMethod = request.getMethod();

        // Check and return
        return requestMethod.equals(bypassToken.get(requestPath));
    }

    private void sendErrorResponse(HttpServletResponse response, ApiResponse<?> apiResponse) throws IOException {
        response.setStatus(apiResponse.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        // Convert ApiResponse object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(apiResponse);

        response.getWriter().write(jsonResponse);
        response.getWriter().flush();
    }
}
