package com.lucca.os_service.services;

import com.lucca.os_service.DTOs.UserRequestRegister;
import com.lucca.os_service.domain.Cliente;
import com.lucca.os_service.domain.Tecnico;
import com.lucca.os_service.domain.User;
import com.lucca.os_service.enums.UserType;
import com.lucca.os_service.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository repository;

    private UserType userType;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    public User createUser(UserRequestRegister data){
        User user = switch (data.userType()) {
            case TECNICO -> new Tecnico(data);
            case CLIENTE -> new Cliente(data);
            default -> throw new IllegalArgumentException("Tipo inválido");
        };

        //Para depuração
        //System.out.println("Usuário cadastrado: " + user.getLogin());

        user.setPassWord(passwordEncoder.encode(data.passWord()));
        this.saveUser(user);
        return user;
    }

    private void saveUser(User user){
        repository.save(user);
    }
}
