package com.lucca.os_service.domain;

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
@Table(name = "TBL_clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends User{

    @OneToMany(mappedBy = "cliente")
    private List<OS> list = new ArrayList<>();
}
