package com.lucca.os_service.services;

import com.lucca.os_service.DTOs.TecnicoDTO;
import com.lucca.os_service.domain.Tecnico;
import com.lucca.os_service.repositorys.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoServices {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(String id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Tecnico createTecnico(TecnicoDTO data){
        Tecnico newUser = new Tecnico(data);
        this.saveTecnico(newUser);
        return newUser;
    }

    public List<Tecnico> getAllUsers(){
        return this.repository.findAll();
    }

    private void saveTecnico(Tecnico tecnico){
        repository.save(tecnico);
    }
}
