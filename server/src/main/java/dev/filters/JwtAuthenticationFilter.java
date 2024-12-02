package dev.filters;

import dev.services.ImpUserDetailsService;
import dev.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final JwtService jwtService;
    private final ImpUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, ImpUserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException{

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
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
                return;
            }
            final String jwtToken = authHeader.substring(7);
            final String userID = jwtService.extractUserID(jwtToken);

            // If userID is existed and Authentication is empty
            if(userID != null && SecurityContextHolder.getContext().getAuthentication() == null)
            {
                // Load user
                UserDetails userDetail = userDetailsService.loadUserByID(userID);
                if(userDetail == null)
                {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
                    return;
                }

                // Check token is valid or not
                if (jwtService.isValidToken(jwtToken, userDetail))
                {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetail,
                                    null,
                                    userDetail.getAuthorities());

                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                   // Log info for checked
                    log.info("Authenticated user: {}", userDetail.getUsername());
                    log.info("Authorities: {}", userDetail.getAuthorities());
                }
            }

            // Log info for checked
            if (SecurityContextHolder.getContext().getAuthentication() != null) {
                log.info("SecurityContext authentication: {}",
                        SecurityContextHolder.getContext().getAuthentication().getName());
                log.info("Granted authorities: {}",
                        SecurityContextHolder.getContext().getAuthentication().getAuthorities());
            } else {
                log.warn("No authentication present in SecurityContext");
            }

             filterChain.doFilter(request,response);

        }catch (Exception e)
        {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
        }
    }

    //Check token is bypass or not
    private boolean isBypassToken(HttpServletRequest request) {
        final Map<String, String> bypassToken = new HashMap<>();
        bypassToken.put("/user", "POST");
        bypassToken.put("/auth/signin", "POST");

        // Get request Endpoint and Method
        String requestPath = request.getServletPath();
        String requestMethod = request.getMethod();

        // Check and return
        return requestMethod.equals(bypassToken.get(requestPath));
    }


}
