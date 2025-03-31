package com.lucca.os_service.repositorys;

import com.lucca.os_service.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, String> {
    Optional<Tecnico> findByLogin(String login);
}
