package com.example.clinica_odontologica_2023.services.impl;

import com.example.clinica_odontologica_2023.entity.Domicilio;
import com.example.clinica_odontologica_2023.entity.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceImplTest {

    private Domicilio domicilio;
    private Domicilio domicilio1;
    private Paciente paciente;
    private Paciente paciente1;
    @Autowired
    private PacienteServiceImpl pacienteService;

    public void cargarDataSet() {
        /*pacienteService = new PacienteServiceImpl(new PacienteDAOH2());
        domicilio = new Domicilio("Av Santa fe", 444, "CABA", "Buenos Aires");
        paciente = new Paciente("Paz", "Santiago", "santi@gmail.com","88888888", LocalDate.of(2011,5,3), domicilio);
        domicilio1 = new Domicilio("Av Avellaneda", 333, "CABA", "Buenos Aires");
        paciente1 = new Paciente("Perez", "Micaela", "mika@gmail.com","99999999",LocalDate.of(2018,9,18), domicilio);
        */
    }

    @Test
    void agregarPaciente(){
        this.cargarDataSet();
        pacienteService.guardarPaciente(paciente);
        assertEquals("Paz",pacienteService.buscarPacienteXId(1).getApellido());
    }

}