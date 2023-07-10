package com.example.clinica_odontologica_2023.services.impl;

import com.example.clinica_odontologica_2023.dao.IDao;
import com.example.clinica_odontologica_2023.dao.IPacienteService;
import com.example.clinica_odontologica_2023.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteServiceImpl {

    private IDao<Paciente> pacienteIDao;
    private IPacienteService pacienteService;

    public PacienteServiceImpl(IDao<Paciente> pacienteIDao,IPacienteService pacienteService) {
        this.pacienteIDao = pacienteIDao;
        this.pacienteService = pacienteService;
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteIDao.guardar(paciente);
    }

    public Paciente buscarPacienteXId(Integer id){
        return pacienteIDao.buscarXId(id);
    }

    public List<Paciente> buscarTodosPacientes() {
        return pacienteIDao.buscarTodos();
    }

    public Paciente buscarPacientePorEmail(String email){
        return pacienteService.buscarXEmail(email);
    }

    public void eliminarPaciente(Integer id){
        pacienteIDao.eliminar(id);
    }

    public Paciente modificarPaciente(Paciente paciente){
        return pacienteIDao.modificar(paciente);
    }
}

