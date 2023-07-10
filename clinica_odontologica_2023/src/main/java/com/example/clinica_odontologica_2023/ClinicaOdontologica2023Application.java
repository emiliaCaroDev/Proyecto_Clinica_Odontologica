package com.example.clinica_odontologica_2023;

import com.example.clinica_odontologica_2023.dao.PacienteDAOH2;
import com.example.clinica_odontologica_2023.db.BaseDeDatos;
import com.example.clinica_odontologica_2023.domain.Domicilio;
import com.example.clinica_odontologica_2023.domain.Paciente;
import com.example.clinica_odontologica_2023.services.impl.PacienteServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.time.LocalDate;

@SpringBootApplication
public class ClinicaOdontologica2023Application {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(ClinicaOdontologica2023Application.class, args);
		BaseDeDatos.crearTabla();
	}
}
