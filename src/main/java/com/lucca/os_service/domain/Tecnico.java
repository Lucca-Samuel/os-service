package com.lucca.os_service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucca.os_service.DTOs.UserRequestRegister;
import com.lucca.os_service.enums.UserType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "TBL_TECNICOS")
@DiscriminatorValue("TECNICO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tecnico extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<OS> list = new ArrayList<>();



    public Tecnico(UserRequestRegister data) {
        this.setName(data.nome());
        this.setCpf(data.cpf());
        this.setTelefone(data.telefone());
        this.setLogin(data.login());
        this.setPassWord(data.passWord());
    }

    @Override
    public UserType getUserType() {
        return UserType.TECNICO;
    }
}
