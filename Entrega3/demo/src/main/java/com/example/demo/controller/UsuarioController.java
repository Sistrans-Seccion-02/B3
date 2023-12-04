package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/crearUsuario")
    public String crearUsuario(Model model){
        model.addAttribute("usuarioNuevo", new Usuario());
        return "usuarioForm";
    }

    @PostMapping("/crearUsuarioNuevo")
    public String crearUsuarioNuevo(@ModelAttribute("usuarioNuevo") Usuario usuario){
       
        Usuario nuevo=new Usuario(
            usuario.getidusuario(), usuario.getnombre(), usuario.getemail(), usuario.getusuario(), usuario.getcontrasena()
        );
        usuarioRepository.save(nuevo);
        return "redirect:/usuarios";
    }
    @PostMapping("/deleteUsuario")
    public String eliminarUsuario(@RequestParam(name="idusuario", required = false) Integer idusuario){
        usuarioRepository.deleteById(idusuario);

        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios")
    public String obtenerTodosLosUsuarios(Model model){
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios";
    }
    
}
