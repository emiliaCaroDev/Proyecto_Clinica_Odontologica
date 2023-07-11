package com.example.clinica_odontologica_2023.dao.impl.H2;

import com.example.clinica_odontologica_2023.dao.IDao;
import com.example.clinica_odontologica_2023.db.BaseDeDatos;
import com.example.clinica_odontologica_2023.entity.Odontologo;
import com.example.clinica_odontologica_2023.entity.Paciente;
import com.example.clinica_odontologica_2023.entity.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
@Component
public class TurnoDAOH2 implements IDao <Turno>{

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private PacienteDAOH2 pacienteDAOH2;
    private OdontologoDAOH2 odontologoDAOH2;

    @Autowired
    public TurnoDAOH2(PacienteDAOH2 pacienteDAOH2, OdontologoDAOH2 odontologoDAOH2) {
        this.pacienteDAOH2 = pacienteDAOH2;
        this.odontologoDAOH2 = odontologoDAOH2;
    }

    @Override
    public Turno guardar(Turno turno) {
        try {
            conn = BaseDeDatos.obtenerConexion();
            ps = conn.prepareStatement("INSERT INTO TURNOS (PACIENTE_ID,ODONTOLOGO_ID,FECHA_HORA) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            Paciente pacienteAsignado = pacienteDAOH2.guardar(turno.getPaciente());
            ps.setInt(1,pacienteAsignado.getId());
            Odontologo odontologoAsignado = odontologoDAOH2.guardar(turno.getOdontologo());
            ps.setInt(2,odontologoAsignado.getId());
            ps.setDate(3,Date.valueOf(turno.getFechaHora()));
            ps.executeUpdate();
            //ps.setDate(3, (Date) Date.from(turno.getFechaHora().atZone(ZoneId.systemDefault()).toInstant()));
            rs=ps.getGeneratedKeys();
            while(rs.next()){
                turno.setId(rs.getInt(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turno;
    }

    @Override
    public Turno buscarXId(Integer id) {
        Turno turno = new Turno();
        try {
            conn = BaseDeDatos.obtenerConexion();
            ps = conn.prepareStatement("SELECT * FROM TURNOS WHERE ID = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                turno.setId(rs.getInt(1));
                turno.setPaciente(pacienteDAOH2.buscarXId(rs.getInt(2)));
                turno.setOdontologo(odontologoDAOH2.buscarXId(rs.getInt(3)));
                turno.setFechaHora(rs.getDate(4).toLocalDate());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turno;
    }

    @Override
    public List<Turno> buscarTodos() {
        List<Turno> turnos = new ArrayList<>();
        try {
            conn = BaseDeDatos.obtenerConexion();
            ps = conn.prepareStatement("SELECT * FROM TURNOS");
            rs=ps.executeQuery();
            while(rs.next()){
                Turno turno = new Turno();
                turno.setId(rs.getInt(1));
                turno.setPaciente(pacienteDAOH2.buscarXId(rs.getInt(2)));
                turno.setOdontologo(odontologoDAOH2.buscarXId(rs.getInt(3)));
                turnos.add(turno);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turnos;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            conn = BaseDeDatos.obtenerConexion();
            ps = conn.prepareStatement("DELETE FROM TURNOS WHERE ID=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Turno modificar(Turno turno) {
        return null;
    }
}
