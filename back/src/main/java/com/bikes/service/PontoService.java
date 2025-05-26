package com.bikes.PontoEletronico.service;

import com.bikes.PontoEletronico.model.RegistroPonto;
import com.bikes.PontoEletronico.model.User;
import com.bikes.PontoEletronico.repository.RegistroPontoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PontoService {
    private final RegistroPontoRepository registroPontoRepository;

    public PontoService(RegistroPontoRepository registroPontoRepository) {
        this.registroPontoRepository = registroPontoRepository;
    }

    public RegistroPonto registrarPonto(User user, TipoRegistro tipo) {
        RegistroPonto registro = new RegistroPonto();
        registro.setUser(user);
        registro.setDataHora(LocalDateTime.now());
        registro.setTipo(tipo);
        return registroPontoRepository.save(registro);

    }

    public List<RegistroPonto> buscarRegistrosPorPeriodo(User user, LocalDateTime inicio, LocalDateTime fim)
}
}