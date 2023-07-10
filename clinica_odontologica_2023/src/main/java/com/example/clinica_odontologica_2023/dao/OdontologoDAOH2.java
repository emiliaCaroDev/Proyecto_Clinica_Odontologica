package com.example.clinica_odontologica_2023.dao;

import com.example.clinica_odontologica_2023.db.BaseDeDatos;
import com.example.clinica_odontologica_2023.domain.Odontologo;
import com.example.clinica_odontologica_2023.domain.Paciente;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class OdontologoDAOH2 implements IDao<Odontologo>{

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        try {
            conn = BaseDeDatos.obtenerConexion();
            ps = conn.prepareStatement("INSERT INTO ODONTOLOGOS(APELLIDO,NOMBRE,MATRICULA) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,odontologo.getApellido());
            ps.setString(2,odontologo.getNombre());
            ps.setString(3,odontologo.getMatricula());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            while(rs.next()){
                odontologo.setId(rs.getInt(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarXId(Integer id) {
        Odontologo odontologo = new Odontologo();
        try {
            conn = BaseDeDatos.obtenerConexion();
            ps = conn.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE ID=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while (rs.next()){
                odontologo.setId(rs.getInt(1));
                odontologo.setApellido(rs.getString(2));
                odontologo.setNombre(rs.getString(3));
                odontologo.setMatricula(rs.getString(4));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return odontologo;
    }


    @Override
    public List<Odontologo> buscarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            conn = BaseDeDatos.obtenerConexion();
            ps = conn.prepareStatement("SELECT * FROM ODONTOLOGOS");
            rs = ps.executeQuery();
            while(rs.next()){
                Odontologo odontologo = new Odontologo();
                odontologo.setId(rs.getInt(1));
                odontologo.setApellido(rs.getString(2));
                odontologo.setNombre(rs.getString(3));
                odontologo.setMatricula(rs.getString(4));
                odontologos.add(odontologo);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return odontologos;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            conn = BaseDeDatos.obtenerConexion();
            ps = conn.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        try {
            conn = BaseDeDatos.obtenerConexion();

            ps = conn.prepareStatement("UPDATE ODONTOLOGOS SET APELLIDO=?,NOMBRE=?,MATRICULA=?  WHERE ID=?");
            ps.setString(1,odontologo.getApellido());
            ps.setString(2,odontologo.getNombre());
            ps.setString(3,odontologo.getMatricula());
            ps.setInt(4,odontologo.getId());
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return odontologo;
    }

}
