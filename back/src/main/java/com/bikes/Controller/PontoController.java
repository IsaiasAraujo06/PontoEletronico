package com.pontoeletronico.controller;

import com.pontoeletronico.model.RegistroPonto;
import com.pontoeletronico.model.TipoRegistro;
import com.pontoeletronico.service.PontoService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController //Une @Controller e @ResponseBody
@RequestMapping("/api/registros") // Mapeia URL's começando com "/api/registros"
public class PontoController {
    private final PontoService pontoService;

    public PontoController(PontoService pontoService) {
        this.pontoService = pontoService;
    }

    @PostMapping //Mapeia as requisições Post
    public RegistroPonto registrarPonto(Authentication authentication,
                                        @RequestParam TipoRegistro tipo) { //Extrai os parâmetros da URL
        String username = authentication.getName();
        // Em uma versão real, você buscaria o User do banco de dados aqui
        // Por enquanto, vamos usar apenas o username
        return pontoService.registrarPonto(username, tipo); //Pega o usuário autenticado e joga para a lógica do Service
    }

    @GetMapping
    public List<RegistroPonto> getRegistros(
            Authentication authentication,
            @RequestParam LocalDateTime inicio,
            @RequestParam LocalDateTime fim) {
        String username = authentication.getName();
        return pontoService.buscarRegistrosPorPeriodo(username, inicio, fim);
    }
}