package com.example.clinica_odontologica_2023.dao;

import com.example.clinica_odontologica_2023.domain.Paciente;

public interface IPacienteService {

    Paciente buscarXEmail(String email);
}
