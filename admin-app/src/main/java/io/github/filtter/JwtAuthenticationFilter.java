package io.github.filtter;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String token = getTokenFromHeader(httpRequest);

//            if (token != null) {
//                LoginUser loginUser = JwtUtils.parseToken(token);
//                UserContext.setCurrentUser(loginUser);
//            }

            chain.doFilter(request, response);
        } finally {
//            UserContext.removeCurrentUser(); // 避免线程复用问题
        }
    }

    private String getTokenFromHeader(HttpServletRequest request) {
        //TODO 这个名字待定
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}