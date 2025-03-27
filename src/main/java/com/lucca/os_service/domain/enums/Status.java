package com.lucca.os_service.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum Status {
    ABERTO(0, "BAIXA"), ANDAMENTO(1, "MEDIA"), ENCERRADO(2, "ALTA");

    private Integer cod;
    private String descricao;

    public static Status toEnum(Integer cod) {
        if(cod == 0) {
            return null;
        }

        for(Status x : Status.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }


        throw new IllegalArgumentException("Status Inválida! " + cod);
    }



}
