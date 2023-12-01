package com.example.demo.repositorio;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.modelo.Servicio;

public interface ServiciosRepository extends MongoRepository<Servicio, String>{
   List<Servicio> findByNombre(String nombre);
}
