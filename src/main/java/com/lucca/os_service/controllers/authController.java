package com.lucca.os_service.controllers;

import com.lucca.os_service.DTOs.LoginRequestDTO;
import com.lucca.os_service.DTOs.ResponseDTO;
import com.lucca.os_service.DTOs.UserRequestRegister;
import com.lucca.os_service.domain.User;
import com.lucca.os_service.infra.security.TokenService;
import com.lucca.os_service.repositorys.UserRepository;
import com.lucca.os_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class authController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.repository.findByLogin(body.login()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if(passwordEncoder.matches(body.passWord(), user.getPassWord())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRequestRegister body){
        Optional<User> user = this.repository.findByLogin(body.login());
        // Verifica se usuário já existe
        if (repository.findByLogin(body.login()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        if(user.isEmpty()){
            User newUser = service.createUser(body);

            // Gera o token e retorna a resposta
            String token = tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
