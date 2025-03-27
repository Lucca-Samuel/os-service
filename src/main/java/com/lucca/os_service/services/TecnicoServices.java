package com.lucca.os_service.services;

import com.lucca.os_service.domain.Tecnico;
import com.lucca.os_service.repositorys.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoServices {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(String id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
