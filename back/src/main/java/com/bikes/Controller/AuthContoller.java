package com.bikes.PontoEletronico.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Combina @Controller e @ResponseBody
@RequestMapping("/api/auth") // Mapeia URL's começando com "/api/auth"
public class AuthController { //*Classe

    @GetMapping("/user-info") // Mapeia as requisições get
    public String getUserInfo(Authentication authentication) {
        return "Usuário autenticado: " + authentication.getName() +  //"getName(): Traz o nome do usuário
                ", Roles: " + authentication.getAuthorities(); //Pega as roles do usuário
    }
}