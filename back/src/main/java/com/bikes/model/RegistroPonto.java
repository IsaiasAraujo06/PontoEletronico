package com.bikes.PontoEletronico.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RegistroPonto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime DataHora;
    private TipoRegistro tipo;

}

public enum TipoRegistro {
    ENTRADA, SAIDA, INICIO_INTERVALO, FIM_INTERVALO
}