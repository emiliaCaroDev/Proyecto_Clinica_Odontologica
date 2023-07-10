package com.example.clinica_odontologica_2023.domain;

import java.time.LocalDate;

public class Paciente {

    private Integer id;
    private String apellido;
    private String nombre;
    private String email;
    private String dni;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;
    private Odontologo odontologo;

    public Paciente(){}

    public Paciente(Integer id, String apellido, String nombre, String email, String dni,LocalDate fechaIngreso,Domicilio domicilio,Odontologo odontologo) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.setDomicilio(domicilio);
        this.setOdontologo(odontologo);
    }

    public Paciente(String apellido, String nombre, String email, String dni,LocalDate fechaIngreso, Domicilio domicilio,Odontologo odontologo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.setDomicilio(domicilio);
        this.setOdontologo(odontologo);
    }

    //getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String toString(){
        return "\nPaciente { Id = "+id+", Apellido = "+apellido+", Nombre = "+nombre+", Email = "+email+", DNI = "+dni+", Fecha ingreso = "+fechaIngreso+domicilio.toString()+odontologo.toString()+" }";
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}
