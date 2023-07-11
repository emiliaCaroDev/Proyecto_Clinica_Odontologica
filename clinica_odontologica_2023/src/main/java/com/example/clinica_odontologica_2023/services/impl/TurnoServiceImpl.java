package com.example.clinica_odontologica_2023.services.impl;

import com.example.clinica_odontologica_2023.dao.impl.H2.TurnoDAOH2;
import com.example.clinica_odontologica_2023.dao.impl.Memoria.TurnoDAOEnMemoria;
import com.example.clinica_odontologica_2023.entity.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoServiceImpl {

    //private TurnoDAOEnMemoria turnoDAOEnMemoria;
    private TurnoDAOH2 turnoDAOH2;

    @Autowired
    public TurnoServiceImpl(TurnoDAOH2 turnoDAOH2) {
        this.turnoDAOH2 = turnoDAOH2;
    }

    public Turno guardarTurno(Turno turno){
        return turnoDAOH2.guardar(turno);
    }

    public List<Turno> listarTurnos(){
        return turnoDAOH2.buscarTodos();
    }

    public Turno buscarTurnoXId(Integer id){
        return turnoDAOH2.buscarXId(id);
    }

    public void eliminarTurno(Integer id){
        Turno turnoAEliminar = buscarTurnoXId(id);
        if(turnoAEliminar != null){
            turnoDAOH2.eliminar(id);
        }
    }

}
