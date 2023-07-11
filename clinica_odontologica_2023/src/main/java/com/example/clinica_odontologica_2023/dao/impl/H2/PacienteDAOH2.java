package com.example.clinica_odontologica_2023.dao.impl.H2;

import com.example.clinica_odontologica_2023.dao.IDao;
import com.example.clinica_odontologica_2023.dao.IPacienteService;
import com.example.clinica_odontologica_2023.dao.impl.H2.DomicilioDAOH2;
import com.example.clinica_odontologica_2023.dao.impl.H2.OdontologoDAOH2;
import com.example.clinica_odontologica_2023.db.BaseDeDatos;
import com.example.clinica_odontologica_2023.entity.Domicilio;
import com.example.clinica_odontologica_2023.entity.Paciente;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteDAOH2 implements IDao<Paciente>, IPacienteService {

    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
    //OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();

    @Override
    public Paciente guardar(Paciente paciente) {
        try {
            conn= BaseDeDatos.obtenerConexion();
            ps=conn.prepareStatement("INSERT INTO PACIENTES(APELLIDO,NOMBRE,EMAIL,DNI,FECHA_INGRESO,DOMICILIO_ID)VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getApellido());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getEmail());
            ps.setString(4, paciente.getDni());
            ps.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            ps.setInt(6,domicilioDAOH2.guardar(paciente.getDomicilio()).getId());
            ps.executeUpdate();
            rs=ps.getGeneratedKeys();

            while(rs.next()){
                paciente.setId(rs.getInt(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente buscarXId(Integer id) {
        Paciente paciente = new Paciente();
        try {
            conn=BaseDeDatos.obtenerConexion();
            ps=conn.prepareStatement("SELECT * FROM PACIENTES WHERE ID=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                paciente.setId(rs.getInt(1));
                paciente.setApellido(rs.getString(2));
                paciente.setNombre(rs.getString(3));
                paciente.setEmail(rs.getString(4));
                paciente.setDni(rs.getString(5));
                paciente.setFechaIngreso(rs.getDate(6).toLocalDate());
                Domicilio domicilio = domicilioDAOH2.buscarXId(rs.getInt(7));
                paciente.setDomicilio(domicilio);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            conn=BaseDeDatos.obtenerConexion();
            ps=conn.prepareStatement("SELECT * FROM PACIENTES");
            rs=ps.executeQuery();
            while(rs.next()){
                Paciente paciente= new Paciente();
                paciente.setId(rs.getInt(1));
                paciente.setApellido(rs.getString(2));
                paciente.setNombre(rs.getString(3));
                paciente.setEmail(rs.getString(4));
                paciente.setDni(rs.getString(5));
                paciente.setFechaIngreso(rs.getDate(6).toLocalDate());
                paciente.setDomicilio(domicilioDAOH2.buscarXId(rs.getInt(7)));
                pacientes.add(paciente);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            conn = BaseDeDatos.obtenerConexion();
            ps = conn.prepareStatement("DELETE FROM PACIENTES WHERE ID=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Paciente modificar(Paciente paciente) {
        try {
            conn = BaseDeDatos.obtenerConexion();
            ps = conn.prepareStatement("UPDATE PACIENTES SET APELLIDO=?,NOMBRE=?,EMAIL=?,DNI=?,FECHA_INGRESO=?,DOMICILIO_ID WHERE ID=?");
            ps.setString(1,paciente.getApellido());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getEmail());
            ps.setString(4, paciente.getDni());
            ps.setDate(5,Date.valueOf(paciente.getFechaIngreso()));
            ps.setInt(6,paciente.getDomicilio().getId());
            ps.setInt(7,paciente.getId());
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente buscarXEmail(String email) {
        Paciente paciente = new Paciente();
        try {
            conn=BaseDeDatos.obtenerConexion();
            ps=conn.prepareStatement("SELECT * FROM PACIENTES WHERE EMAIL=?");
            ps.setString(1,email);
            rs=ps.executeQuery();
            while(rs.next()){
                paciente.setId(rs.getInt(1));
                paciente.setApellido(rs.getString(2));
                paciente.setNombre(rs.getString(3));
                paciente.setEmail(rs.getString(4));
                paciente.setDni(rs.getString(5));
                paciente.setFechaIngreso(rs.getDate(6).toLocalDate());
                Domicilio domicilio = domicilioDAOH2.buscarXId(rs.getInt(7));
                paciente.setDomicilio(domicilio);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }
}
