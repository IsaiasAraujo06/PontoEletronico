package com.pontoeletronico.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RegistroPonto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // Temporário - será substituído por relação com User depois

    private LocalDateTime dataHora;
    private TipoRegistro tipo; // ENTRADA, SAIDA, etc.

    // Getters e Setters
}