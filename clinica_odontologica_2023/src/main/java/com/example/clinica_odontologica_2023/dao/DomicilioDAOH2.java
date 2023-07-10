package com.example.clinica_odontologica_2023.dao;

import com.example.clinica_odontologica_2023.db.BaseDeDatos;
import com.example.clinica_odontologica_2023.domain.Domicilio;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DomicilioDAOH2 implements IDao<Domicilio>{

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        try {
            conn= getConnection();
            ps=conn.prepareStatement("INSERT INTO DOMICILIOS(CALLE,NUMERO,LOCALIDAD,PROVINCIA) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2,domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());

            ps.executeUpdate();
            rs=ps.getGeneratedKeys();
            while(rs.next()){
                domicilio.setId(rs.getInt(1));
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return domicilio;
    }

    @Override
    public Domicilio buscarXId(Integer id) {
        Domicilio domicilio = new Domicilio();
        try {
            conn=getConnection();
            ps=conn.prepareStatement("SELECT * FROM DOMICILIOS WHERE ID = ?");
            ps.setInt(1,id);

            rs=ps.executeQuery();
            while(rs.next()){
                domicilio.setId(rs.getInt(1));
                domicilio.setCalle(rs.getString(2));
                domicilio.setNumero(rs.getInt(3));
                domicilio.setLocalidad(rs.getString(4));
                domicilio.setProvincia(rs.getString(5));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                conn.close();
            }catch(Exception e){

            }
        }
        return domicilio;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        List<Domicilio> domicilios = new ArrayList<>();
        try {
            conn = getConnection();
            ps= conn.prepareStatement("SELECT * FROM DOMICILIOS");
            rs=ps.executeQuery();

            while(rs.next()){
                Domicilio domicilio = new Domicilio();
                domicilio.setId(rs.getInt(1));
                domicilio.setCalle(rs.getString(2));
                domicilio.setNumero(rs.getInt(3));
                domicilio.setLocalidad(rs.getString(4));
                domicilio.setProvincia(rs.getString(5));
                domicilios.add(domicilio);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return domicilios;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            conn=getConnection();
            ps=conn.prepareStatement("DELETE FROM DOMICILIOS WHERE ID = ?");
            ps.setInt(1,id);
            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Domicilio modificar(Domicilio domicilio) {

        try {
            conn=getConnection();
            ps=conn.prepareStatement("UPDATE DOMICILIOS SET CALLE=?,NUMERO=?,LOCALIDAD=?, PROVINCIA= ? WHERE ID=?");
            ps.setString(1,domicilio.getCalle());
            ps.setInt(2,domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4,domicilio.getProvincia());
            ps.setInt(5,domicilio.getId());
            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return domicilio;
    }

}
