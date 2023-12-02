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

import com.example.demo.modelo.Consumo;
import com.example.demo.modelo.Salida;
import com.example.demo.repositorio.ConsumoRepository;
import com.example.demo.repositorio.SalidasRepository;


@Controller
public class SalidaController {

    @Autowired
    private SalidasRepository salidaRepository; 

    @Autowired
    private ConsumoRepository consumoRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;


    @GetMapping("/salidas")
    public String getSalidas(Model model)
    {
        model.addAttribute("nuevaSalida", salidaRepository.findAll());
        return "salidas";
    }

    @GetMapping("/mostrarResultadosAgregacionSal")
    public String mostrarResultados(Model model) {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("consumos")
                .localField("consumos")
                .foreignField("_id")
                .as("Lista_consumos");

        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);

        List<Salida> salidas = mongoTemplate.aggregate(aggregation, "salidas", Salida.class).getMappedResults();
        model.addAttribute("nuevaSalida", salidas);

        return "resultadosSalida";
    }

    @GetMapping("/salidaForm")
    public String mostrarFormulario(Model model) {

        model.addAttribute("nuevaSalida", new Salida());
        model.addAttribute(("consumosDisponibles"), consumoRepository.findAll());
        
        return "salidaForm";
    }

    @PostMapping("/crearSalida")
    public String crearSalida(@ModelAttribute("nuevaSalida") Salida nuevaSalida){

        Consumo nuevoConsumo = new Consumo(
            nuevaSalida.getConsumos().get(0).getIdconsumo(),
            nuevaSalida.getConsumos().get(0).getHabitacion(),
            nuevaSalida.getConsumos().get(0).getFechaConsumo(),
            nuevaSalida.getConsumos().get(0).getEntrada(),
            nuevaSalida.getConsumos().get(0).getServicio()
            
        );

        consumoRepository.save(nuevoConsumo);

        nuevaSalida.setConsumos(Collections.singletonList(nuevoConsumo));

        salidaRepository.save(nuevaSalida);

        return "redirect:/salidas";

    }
    




    
}
