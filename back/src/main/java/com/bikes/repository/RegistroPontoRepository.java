package com.pontoeletronico.repository;

import com.pontoeletronico.model.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {
    List<RegistroPonto> findByUsernameAndDataHoraBetween(String username, LocalDateTime inicio, LocalDateTime fim);
}