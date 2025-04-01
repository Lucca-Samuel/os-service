package com.lucca.os_service.DTOs;

import com.lucca.os_service.enums.UserType;

public record UserRequestRegister(String nome, String cpf, String telefone, String login, String passWord, UserType userType) {
}
