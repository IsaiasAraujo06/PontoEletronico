package com.bikes.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;


@RestController
@Controller 
@ResponseBody
@RequestMapping("/registro-ponto")

public class RegistroPontoController {
    @GetMapping
    public String registroPonto() {
        return "Registro de ponto realizado com sucesso!";
    }
}
