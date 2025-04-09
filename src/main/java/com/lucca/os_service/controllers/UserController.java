package com.lucca.os_service.controllers;

import com.lucca.os_service.domain.Cliente;
import com.lucca.os_service.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class UserController {

    @Autowired
    private ClientServices services;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        List<Cliente> clientes = this.services.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
}
