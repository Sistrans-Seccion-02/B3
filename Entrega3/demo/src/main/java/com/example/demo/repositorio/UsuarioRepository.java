package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Usuario;
import java.util.List;


public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {

    List<Usuario> findByidusuario(Integer idusuario);
} 
    

