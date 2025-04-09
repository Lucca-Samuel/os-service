package com.lucca.os_service.services;

import com.lucca.os_service.domain.Cliente;
import com.lucca.os_service.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getAllClientes(){
        return this.repository.findAll();
    }
}
