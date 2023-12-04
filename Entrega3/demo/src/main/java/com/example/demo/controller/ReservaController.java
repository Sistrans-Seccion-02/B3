package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.demo.modelo.BebidaEmbedded;
import com.example.demo.modelo.BebidaTipos;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.UsuarioEmbedded;
import com.example.demo.repositorio.BebidaTiposRepository;
import com.example.demo.repositorio.ReservaRepository;


@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;


    @GetMapping("/reservas")
    public String obtenerTodasLasReservas(Model model){
        model.addAttribute("reservas", reservaRepository.findAll());
        return "reservas";
    }

    @GetMapping("/reservasForm")
    public String mostrarFormulario(Model model) {
        // Creamos una instancia vacía para el nuevo BebidaTipos
        model.addAttribute("nuevaReserva", new Reserva());
        return "reservasForm";
    }

    @PostMapping("/crearReserva")
    public String crearReserva(@ModelAttribute("nuevaReserva") Reserva nuevaReserva) {

        // Creamos una nueva bebida utilizando los datos del formulario
        UsuarioEmbedded nuevoUsuario = new UsuarioEmbedded(
            nuevaReserva.getusuario().get(0).getidusuario(),
            nuevaReserva.getusuario().get(0).getnombre(),
            nuevaReserva.getusuario().get(0).getemail(),
            nuevaReserva.getusuario().get(0).getusuario(), 
            nuevaReserva.getusuario().get(0).getcontrasena()
        );

        // Agregamos la bebida a la lista de bebidas en el nuevo tipo de bebida
        nuevaReserva.setusuario(Collections.singletonList(nuevoUsuario));


        // Guardamos el nuevo tipo de bebida
        reservaRepository.save(nuevaReserva);
        return "redirect:/reservas";

    }

    @GetMapping("/addUsuario")
    public String añadirUsuario(@RequestParam(name = "idreserva", required = false) Integer idreserva, Model model){
        model.addAttribute("idreserva", idreserva);
        model.addAttribute("usuario", new UsuarioEmbedded());


        return "addUsuarioForm";
    }

    @PostMapping("/deleteReserva")
    public String eliminarReserva(@RequestParam(name = "idreserva", required = false) Integer idreserva){
        
        for (Reserva reserva: reservaRepository.findByidreserva(idreserva))
        {
            reservaRepository.delete(reserva);
        }

        return "redirect:/reservas";
        
    }

    @PostMapping("/addUsuarioSave")
    public String añadirUsuarioSave(@RequestParam("idreserva") Integer idReserva,
    @ModelAttribute("usuario") UsuarioEmbedded usuario){

        // Creamos una nueva bebida utilizando los datos del formulario
        UsuarioEmbedded nuevoUsuario = new UsuarioEmbedded(
            usuario.getidusuario(),
            usuario.getnombre(),
            usuario.getemail(),
            usuario.getusuario(), 
            usuario.getcontrasena()
        );

        System.out.println(idReserva);
        //Buscamos los tipos de bebida con ese nombre
        List<Reserva> res = reservaRepository.findByidreserva(idReserva);

        //Añadimos esa bebida a todos los tipos de bebidas con ese nombre
        for (Reserva tipoReserva:res){
            if (tipoReserva.getusuario() == null){
                List<UsuarioEmbedded> emptyList = new ArrayList<>();
                tipoReserva.setusuario(emptyList);
            }
            tipoReserva.addusuario(nuevoUsuario);

            //Persistemos la modificacion en la base de datos
            reservaRepository.save(tipoReserva);
        }
        
        return "redirect:/reservas";


    }

    @GetMapping("/req2")
    public String getIndiceOcupacion(Model model) {
        model.addAttribute("indiceocupacion", reservaRepository.indiceocupacion());
        return "req2";
    }



}




    
    

