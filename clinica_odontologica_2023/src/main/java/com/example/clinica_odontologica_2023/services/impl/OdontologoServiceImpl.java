package com.example.clinica_odontologica_2023.services.impl;

import com.example.clinica_odontologica_2023.dao.IDao;
import com.example.clinica_odontologica_2023.entity.Odontologo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoServiceImpl{

    private IDao<Odontologo> odontologoIDao;

    public OdontologoServiceImpl(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }

    public Odontologo buscarOdontologo(Integer id){
        return odontologoIDao.buscarXId(id);
    }

    public List<Odontologo> buscarTodosOdontologos(){
        return odontologoIDao.buscarTodos();
    }

    public void eliminarOdontologo(Integer id){
        odontologoIDao.eliminar(id);
    }

    public Odontologo modificarOdontologo(Odontologo odontologo){
        return odontologoIDao.modificar(odontologo);
    }
}
