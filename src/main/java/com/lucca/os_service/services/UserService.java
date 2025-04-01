package com.lucca.os_service.services;

import com.lucca.os_service.DTOs.TecnicoDTO;
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
    private UserRepository repository;

    private UserType userType;

    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    public User createUser(UserRequestRegister data){
        /**
        User user = null;
        if (data.userType() == UserType.TECNICO){
            user = new Tecnico(data);
        }else if(data.userType() == UserType.CLIENTE){
            user = new Cliente(data);
        }else {
            throw new IllegalArgumentException("Tipo de usuário inválido: " + data.userType());
        }
        this.saveUser(user);
        return user;**/

        User user = switch (data.userType()) {
            case TECNICO -> new Tecnico(data);
            case CLIENTE -> new Cliente(data);
            default -> throw new IllegalArgumentException("Tipo inválido");
        };

        user.setPassWord(passwordEncoder.encode(data.passWord()));
        this.saveUser(user);
        return user;
    }

    private void saveUser(User user){
        repository.save(user);
    }
}
