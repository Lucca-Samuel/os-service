package com.lucca.os_service.services;

import com.lucca.os_service.domain.Tecnico;
import com.lucca.os_service.repositorys.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoServices {


    /**
     * Área do CRUD do Técnico
     */

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(String id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElse(null);
    }

    /**
     * Não utilizado
     * lógica no UserService
     * @param data
     * @return
     */
    /**public Tecnico createTecnico(TecnicoDTO data){
        Tecnico newUser = new Tecnico(data);
        this.saveTecnico(newUser);
        return newUser;
    }**/

    public List<Tecnico> getAllUsers(){
        return this.repository.findAll();
    }

    /**private void saveTecnico(Tecnico tecnico){
        repository.save(tecnico);
    }**/

    /**
     * Fim do CRUD
     */


    /**
     * Início das ações do técnico dentro do sistema
     */

    private void CriarOs(){
        System.out.println("Criando OS");
    }

    private void SetarStatusDaOs(){
        System.out.println("Alteração do status da OS");
    }

    /**
     * Fim da área de ações inSystem
     */
}
