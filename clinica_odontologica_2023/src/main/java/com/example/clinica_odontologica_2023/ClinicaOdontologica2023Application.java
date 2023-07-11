package com.example.clinica_odontologica_2023;

import com.example.clinica_odontologica_2023.db.BaseDeDatos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class ClinicaOdontologica2023Application {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(ClinicaOdontologica2023Application.class, args);
		BaseDeDatos.crearTabla();
	}
}
