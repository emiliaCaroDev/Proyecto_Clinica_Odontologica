package com.example.clinica_odontologica_2023.controllers;

import com.example.clinica_odontologica_2023.domain.Paciente;
import com.example.clinica_odontologica_2023.services.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PacienteController {

    private PacienteServiceImpl pacienteService;

    @Autowired
    public PacienteController(PacienteServiceImpl pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/pacientes")
    public Paciente savePaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @GetMapping("/pacientes")
    public List<Paciente> getAllPaciente(){
        return pacienteService.buscarTodosPacientes();
    }

    @GetMapping("/pacientes/email")
    public Paciente getPacienteXEmail(@RequestParam ("email") String email){
        return pacienteService.buscarPacientePorEmail(email);
    }

    @GetMapping("/pacientes/{id}")
    public Paciente getPacienteById(@PathVariable ("id") Integer id){
        return pacienteService.buscarPacienteXId(id);
    }

    @DeleteMapping("pacientes/{id}")
    public void deletePaciente(@PathVariable ("id") Integer id){
        pacienteService.eliminarPaciente(id);
    }

    @PutMapping("/pacientes")
    public Paciente updatePaciente(@RequestBody Paciente paciente){
        return pacienteService.modificarPaciente(paciente);
    }


}
