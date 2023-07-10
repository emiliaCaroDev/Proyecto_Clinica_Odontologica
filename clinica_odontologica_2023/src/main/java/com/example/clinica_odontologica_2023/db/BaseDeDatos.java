package com.example.clinica_odontologica_2023.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {

    private static String DRIVER = "org.h2.Driver";
    private static String URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'src/main/java/com/example/Clinica_Odontologica_2023/create.sql'";
    private static String USER = "sa";
    private static String PASS = "";

    public static Connection crearTabla() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public static Connection obtenerConexion() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection("jdbc:h2:~/test",USER,PASS);
    }

}
