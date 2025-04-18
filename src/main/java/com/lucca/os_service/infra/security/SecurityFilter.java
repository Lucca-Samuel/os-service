package com.lucca.os_service.infra.security;


import com.lucca.os_service.domain.User;
import com.lucca.os_service.repositorys.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {


    @Autowired
    TokenService tokenService;
    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Apenas para depuração
        //System.out.println("Interceptando requisição para: " + request.getRequestURI());

        var token = this.recoverToken(request);
        var login = tokenService.validateToken(token);

        if(login != null){
            User user = userRepository.findByLogin(login).orElseThrow(() -> new RuntimeException("User Not Found"));

            /**
             * Ignore, apneas para testes
             */
            /**Optional<User> optionalUser = userRepository.findByLogin(login);
            if(optionalUser.isEmpty()) {
                filterChain.doFilter(request, response);
                return;
            }
            User user = optionalUser.get();**/


            var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            var authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }


    private String recoverToken(HttpServletRequest request){
     var authHeader = request.getHeader("Authorization");
     if(authHeader == null) return null;
     return authHeader.replace("Bearer ", "");
     }

    /**
     * Ignore, apneas para testes
     */
    /**private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.substring(7); // Remove "Bearer " corretamente
    }**/
}
