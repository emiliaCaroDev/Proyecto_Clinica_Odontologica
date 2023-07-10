package com.example.clinica_odontologica_2023.dao;

import com.example.clinica_odontologica_2023.domain.Odontologo;

import java.util.*;

public interface IOdontologoService {
    List<Odontologo> buscarTodos();
    Odontologo buscarXMatricula(String matricula);
    Odontologo buscarXId(Integer id);
}
