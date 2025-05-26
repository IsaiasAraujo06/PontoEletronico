package com.bikes.PontoEletronico.repository;

import com.bikes.PontoEletronico.model.RegistroPonto;
import com.bikes.PontoEletronico.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {
    List<RegistroPonto> findByUserAndDataHoraBetween(User user, LocalDateTime  inicio, LocalDateTime fim);
}