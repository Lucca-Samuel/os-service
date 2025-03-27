package com.lucca.os_service.repositorys;

import com.lucca.os_service.domain.OS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OSRepository extends JpaRepository<OS, Integer> {
}
