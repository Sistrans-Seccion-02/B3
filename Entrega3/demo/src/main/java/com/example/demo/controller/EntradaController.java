package com.example.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Entrada;
import com.example.demo.modelo.Reserva;
import com.example.demo.repositorio.EntradaRepository;
import com.example.demo.repositorio.ReservaRepository;

@Controller
public class EntradaController {
    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired 
    private MongoTemplate mongoTemplate;

    @GetMapping("/entradas")
    public String getEntradas(Model model){
        model.addAttribute("nuevaEntrada", entradaRepository.findAll());
        return "entradas";
    }

    @GetMapping("/mostrarResultadoAgregacionEntrada")
    public String mostrarResultado(Model model){
        LookupOperation lookupOperation=LookupOperation.newLookup()
                .from("reservas")
                .localField("reservas")
                .foreignField("_id")
                .as("lista_reservas");
        Aggregation aggregation=Aggregation.newAggregation(lookupOperation);
        List<Entrada> entradas=mongoTemplate.aggregate(aggregation, "entradas", Entrada.class).getMappedResults();
        model.addAttribute("nuevaEntrada", entradas);

        return "resultadoEntrada";
    }

    @GetMapping("/entradaForm")
    public String mostrarFormulario(Model model){
        model.addAttribute("nuevaEntrada", new Entrada());
        model.addAttribute(("reservasDisponibles"), reservaRepository.findAll());

        return "entradaForm";
    }

    @PostMapping("/crearEntrada")
    public String crearEntrada(@ModelAttribute("nuevaEntrada") Entrada nuevaEntrada){
        Reserva nuevaReserva=new Reserva(
            nuevaEntrada.getreserva().get(0).getidreserva(),
            nuevaEntrada.getreserva().get(0).getnpersonas(),
            nuevaEntrada.getreserva().get(0).getfechaentrada(),
            nuevaEntrada.getreserva().get(0).getfechasalida(),
            nuevaEntrada.getreserva().get(0).getusuario(),
            nuevaEntrada.getreserva().get(0).gethabitacion()
        );

        reservaRepository.save(nuevaReserva);
        nuevaEntrada.setreserva(Collections.singletonList(nuevaReserva));
        entradaRepository.save(nuevaEntrada);
        return "redirect:/entradas";
    }
}
