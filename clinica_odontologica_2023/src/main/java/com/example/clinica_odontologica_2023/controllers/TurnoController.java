package com.example.clinica_odontologica_2023.controllers;

import com.example.clinica_odontologica_2023.entity.Turno;
import com.example.clinica_odontologica_2023.services.impl.TurnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

private TurnoServiceImpl turnoService;

    @Autowired
    public TurnoController(TurnoServiceImpl turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public Turno saveTurno(@RequestBody Turno turno){
        return turnoService.guardarTurno(turno);
    }

    @GetMapping
    public List<Turno> getAllTurnos(){
        return turnoService.listarTurnos();
    }

    @GetMapping("/{id}")
    public Turno getTurnoById(@PathVariable ("id") Integer id){
        return turnoService.buscarTurnoXId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTurno(@PathVariable ("id") Integer id){
        turnoService.eliminarTurno(id);
    }
}
