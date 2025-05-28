package com.pontoeletronico.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity //Indica que é uma tabela de banco de dados
public class RegistroPonto {
    @Id // Indica que é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura o ID para ser gerado automaticamente
    private Long id;

    private String username; // Temporário - será substituído por relação com User depois
    private LocalDateTime dataHora;
    private TipoRegistro tipo; // ENTRADA, SAIDA, etc.

    // Getters e Setters
}