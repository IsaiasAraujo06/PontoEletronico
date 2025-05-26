package com.bikes.PontoEletronico;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private Int password;

    private String nome;
    private Int cpf;
    private Int numero;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> Cargos;
}