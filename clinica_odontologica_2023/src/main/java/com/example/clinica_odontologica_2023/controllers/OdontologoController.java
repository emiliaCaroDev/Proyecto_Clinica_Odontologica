package com.example.clinica_odontologica_2023.controllers;

import com.example.clinica_odontologica_2023.entity.Odontologo;
import com.example.clinica_odontologica_2023.services.impl.OdontologoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class OdontologoController {

    private OdontologoServiceImpl odontologoService;

    @Autowired
    public OdontologoController(OdontologoServiceImpl odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/odontologos")
    public Odontologo addOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologo(odontologo);
    }

    @GetMapping("/odontologos/{id}")
    public Odontologo getOdontologoById(@PathVariable ("id") Integer id){
        return odontologoService.buscarOdontologo(id);
    }

    @GetMapping("/odontologos")
    public List<Odontologo> getAllOdontologos(){
        return odontologoService.buscarTodosOdontologos();
    }

    @DeleteMapping("/odontologos/{id}")
    public void eliminarOdontologo(@PathVariable ("id") Integer id){
        odontologoService.eliminarOdontologo(id);
    }

    @PutMapping("/odontologos")
    public Odontologo actualizarOdontologo(@RequestBody Odontologo odontologo){
        Odontologo odontologoABuscar = odontologoService.buscarOdontologo(odontologo.getId());
        if(odontologoABuscar!=null){
            return odontologoService.modificarOdontologo(odontologo);
        }
        else{
            return  null;
        }

    }

}
