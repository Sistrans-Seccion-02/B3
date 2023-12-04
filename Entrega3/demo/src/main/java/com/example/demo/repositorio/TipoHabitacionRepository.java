package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, String>{

    // Aquí puedes agregar métodos para buscar por diferentes atributos si es necesario
    List<TipoHabitacion> findByNombre(String nombre);
}
