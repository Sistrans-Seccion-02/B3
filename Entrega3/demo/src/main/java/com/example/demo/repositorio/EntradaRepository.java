package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Entrada;

public interface EntradaRepository extends MongoRepository<Entrada, Integer> {
    
}
