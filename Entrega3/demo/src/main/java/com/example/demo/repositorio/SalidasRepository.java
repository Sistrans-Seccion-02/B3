package com.example.demo.repositorio;

import com.example.demo.modelo.Salida;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalidasRepository extends MongoRepository<Salida, String> {
    
}
