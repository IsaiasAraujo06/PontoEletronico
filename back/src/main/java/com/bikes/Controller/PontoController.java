package com.pontoeletronico.controller;

import com.pontoeletronico.model.RegistroPonto;
import com.pontoeletronico.model.TipoRegistro;
import com.pontoeletronico.model.User;
import com.pontoeletronico.service.PontoService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class PontoController {
    private final PontoService pontoService;

    public PontoController(PontoService pontoService) {
        this.pontoService = pontoService;
    }

    @PostMapping
    public RegistroPonto registrarPonto(@AuthenticationPrincipal User user, @RequestParam TipoRegistro tipo) {
        return pontoService.registrarPonto(user, tipo);
    }

    @GetMapping
    public List<RegistroPonto> getRegistros(
            @AuthenticationPrincipal User user,
            @RequestParam LocalDateTime inicio,
            @RequestParam LocalDateTime fim) {
        return pontoService.buscarRegistrosPorPeriodo(user, inicio, fim);
    }
}