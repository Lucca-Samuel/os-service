package com.lucca.os_service.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucca.os_service.domain.enums.Prioridade;
import com.lucca.os_service.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_OS")
@Getter
@Setter
@AllArgsConstructor
public class OS {

    @Id /*Informa que o atributo é uma PK*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*Informa ao JPA que a maneira de gerar a PK vai ficar por conta do DB*/
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm") /*Informa o formato que devera ser armazenado no DB*/
    private LocalDateTime dataAbertura;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataFechamento;
    private Integer prioridade;
    private String observacoes;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "TECNICO_ID_FK")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID_FK")
    private User cliente;


    public OS() {
        super();
        this.setDataAbertura(LocalDateTime.now());
        this.setPrioridade(0);
        this.setStatus(0);
    }

    public OS(Integer id, Prioridade prioridade, String observacoes, Status status,
              Tecnico tecnico, Cliente cliente) {
        super();
        this.id = id;
        this.setDataAbertura(LocalDateTime.now());
        this.prioridade = (prioridade == null) ? 0 : prioridade.getCod();
        this.observacoes = observacoes;
        this.status = (status == null) ? 0 : status.getCod();
        this.tecnico = tecnico;
        this.cliente = cliente;
    }


}
