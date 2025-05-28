package com.pontoeletronico.service;

import com.pontoeletronico.model.RegistroPonto;
import com.pontoeletronico.model.TipoRegistro;
import com.pontoeletronico.repository.RegistroPontoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PontoService {
    private final RegistroPontoRepository registroPontoRepository;

    public PontoService(RegistroPontoRepository registroPontoRepository) {
        this.registroPontoRepository = registroPontoRepository;
    }

    public RegistroPonto registrarPonto(String username, TipoRegistro tipo) {
        RegistroPonto registro = new RegistroPonto();
        registro.setUsername(username); // Temporário - sem relação com User ainda
        registro.setDataHora(LocalDateTime.now());
        registro.setTipo(tipo);
        return registroPontoRepository.save(registro);
    }

    public List<RegistroPonto> buscarRegistrosPorPeriodo(String username,
                                                         LocalDateTime inicio,
                                                         LocalDateTime fim) {
        return registroPontoRepository.findByUsernameAndDataHoraBetween(username, inicio, fim);
    }
}