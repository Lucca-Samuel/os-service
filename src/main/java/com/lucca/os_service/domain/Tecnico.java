package com.lucca.os_service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucca.os_service.DTOs.TecnicoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_TECNICOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tecnico extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<OS> list = new ArrayList<>();


    public Tecnico(TecnicoDTO data){
        this.setName(data.nome());
        this.setCpf(data.cpf());
        this.setTelefone(data.telefone());
    }
}
