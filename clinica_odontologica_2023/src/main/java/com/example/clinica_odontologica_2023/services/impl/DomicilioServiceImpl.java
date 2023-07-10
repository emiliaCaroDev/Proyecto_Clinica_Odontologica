package com.example.clinica_odontologica_2023.services.impl;

import com.example.clinica_odontologica_2023.dao.IDao;
import com.example.clinica_odontologica_2023.domain.Domicilio;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DomicilioServiceImpl {

    private IDao<Domicilio> domicilioIDao;

    public DomicilioServiceImpl(IDao<Domicilio> domicilioIDao) {
        this.domicilioIDao = domicilioIDao;
    }

    public Domicilio guardarDomicilio(Domicilio domicilio){
        return domicilioIDao.guardar(domicilio);
    }

    public Domicilio buscarDomicilioXId(Integer id){
        return domicilioIDao.buscarXId(id);
    }

    public List<Domicilio> buscarTodosDomicilios(){
        return domicilioIDao.buscarTodos();
    }

    public void eliminarDomicilio(Integer id){
        domicilioIDao.eliminar(id);
    }
}
