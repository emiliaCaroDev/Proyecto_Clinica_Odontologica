package com.example.clinica_odontologica_2023.controllers;

import com.example.clinica_odontologica_2023.domain.Domicilio;
import com.example.clinica_odontologica_2023.services.impl.DomicilioServiceImpl;
import com.example.clinica_odontologica_2023.services.impl.DomicilioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController {

    private DomicilioServiceImpl domicilioService;

    @Autowired
    public DomicilioController(DomicilioServiceImpl domicilioService) {
        this.domicilioService = domicilioService;
    }

    @PostMapping("/registrar")
    public Domicilio saveDomicilio(@RequestBody  Domicilio domicilio){
        return domicilioService.guardarDomicilio(domicilio);
    }


    @GetMapping("/domicilios")
    public List<Domicilio> getAllDomicilios(){
        return domicilioService.buscarTodosDomicilios();
    }

    @GetMapping("/{id}")
    public Domicilio getDomicilioById(@PathVariable Integer id){
        return domicilioService.buscarDomicilioXId(id);
    }
}
