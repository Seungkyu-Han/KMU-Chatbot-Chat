package CoBo.ChatbotChat.Config.Jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authorization != null && authorization.startsWith("Bearer ")){
            String token = authorization.split(" ")[1];
            if(jwtTokenProvider.isAccessToken(token) && jwtTokenProvider.isActiveState(token)){
                Integer studentId = jwtTokenProvider.getStudentId(token);
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(studentId, null, List.of(new SimpleGrantedAuthority(jwtTokenProvider.getUserRole(token)))));
            }
        }

        filterChain.doFilter(request, response);

    }
}
