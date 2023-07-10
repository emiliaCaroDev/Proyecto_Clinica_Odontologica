package com.example.clinica_odontologica_2023.services.impl;

import com.example.clinica_odontologica_2023.dao.IDao;
import com.example.clinica_odontologica_2023.dao.IOdontologoService;
import com.example.clinica_odontologica_2023.domain.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Arrays;

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
