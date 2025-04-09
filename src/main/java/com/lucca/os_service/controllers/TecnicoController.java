package com.lucca.os_service.controllers;

import com.lucca.os_service.domain.Tecnico;
import com.lucca.os_service.services.TecnicoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoServices tecnicoServices;

    /**
    @PostMapping
    public ResponseEntity<Tecnico> salvarTecnico(@RequestBody TecnicoDTO tecnicoDTO){
        Tecnico newTecnico = tecnicoServices.createTecnico(tecnicoDTO);
        return new ResponseEntity<>(newTecnico, HttpStatus.CREATED);
    }**/

    @GetMapping
    public ResponseEntity<List<Tecnico>> getAllTecnicos(){
        List<Tecnico> tecnicos = this.tecnicoServices.getAllUsers();
        return new ResponseEntity<>(tecnicos, HttpStatus.OK);
    }

}

