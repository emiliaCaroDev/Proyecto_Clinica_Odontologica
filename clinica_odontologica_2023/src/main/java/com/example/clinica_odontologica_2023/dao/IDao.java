package com.example.clinica_odontologica_2023.dao;

import java.util.*;

public interface IDao<T>{
    T guardar(T t);
    T buscarXId(Integer id);
    List<T> buscarTodos();

    void eliminar(Integer id);

    T modificar(T t);

}
