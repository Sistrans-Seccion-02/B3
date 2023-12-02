package com.example.demo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.demo.modelo.Consumo;
import com.example.demo.modelo.ServicioEmbedded;
import com.example.demo.repositorio.ConsumoRepository;
import com.example.demo.repositorio.ConsumoRepository.ClienteInfo;
import com.example.demo.repositorio.ConsumoRepository.ClienteInfoAvanzado;

@Controller
public class ConsumoController {

    @Autowired
    private ConsumoRepository consumoRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @GetMapping("/consumos")
    public String obtenerTodosLosConsumos(Model model){
        model.addAttribute("consumos", consumoRepository.findAll());
        return "consumos";
    }


    @GetMapping("consumosForm")
    public String mostrarFormulario(Model model) {
        // Creamos una instancia vacía para el nuevo Consumo
        model.addAttribute("nuevoConsumo", new Consumo());
        return "consumosForm";
    }

    @PostMapping("/crearConsumo")
    public String crearConsumo(@ModelAttribute("nuevoConsumo") Consumo nuevoConsumo) {

        ServicioEmbedded nuevoServicio = new ServicioEmbedded(
            nuevoConsumo.getServicio().get(0).getNombre(),
            nuevoConsumo.getServicio().get(0).getTipo(),
            nuevoConsumo.getServicio().get(0).getPrecio()
        );

        nuevoConsumo.setServicio(Collections.singletonList(nuevoServicio));

        // Guardamos el nuevo consumo
        consumoRepository.save(nuevoConsumo);
        return "redirect:/consumos";
    }

    @GetMapping("/addServicio")
    public String addServicio(@RequestParam(name="idconsumo", required=false) String idconsumo,  Model model) {
        model.addAttribute("idconsumo", idconsumo);
        model.addAttribute("servicio", new ServicioEmbedded());
        return "addServicioForm";
        
    }

    @PostMapping("/deleteConsumo")
    public String deleteConsumo(@RequestParam(name="idconsumo", required=false) String idconsumo) {
        for (Consumo cons: consumoRepository.findByidconsumo(idconsumo)){
            consumoRepository.delete(cons);
        }
        return "redirect:/consumos";
    }

    @PostMapping("/addServicioSave")
    public String añadirConsumoSave(@RequestParam("idconsumo") String idconsumo, @ModelAttribute("servicio") ServicioEmbedded serv){
        ServicioEmbedded nuevoServicio = new ServicioEmbedded(
            serv.getNombre(),
            serv.getTipo(),
            serv.getPrecio()
        );
        System.out.println(idconsumo);

        List<Consumo> cons = consumoRepository.findByidconsumo(idconsumo);
        
        for (Consumo c: cons){
            if(c.getServicio()==null){
                List<ServicioEmbedded> emptyList = new ArrayList<>();
                c.setServicio(emptyList);
            }
            c.addServicio(nuevoServicio);
            consumoRepository.save(c);
        }
        return "redirect:/consumos";
    }

    @GetMapping("/req1")
    public String getConsumoPorHabitacion(Model model) {
        model.addAttribute("costoPorHabitaciones", consumoRepository.costoPorHabitacion());
        return "req1";
    }
    
/*
    @GetMapping("/buscarConsumo")
    public String buscarConsumosEntreFechas(
        @Param("fechaInicio") String fechaInicio,
        @Param("fechaFin") String fechaFin,
        Model model
    ) {
        List<ClienteInfo> consumos = consumoRepository.findConsumoInfo(fechaInicio, fechaFin);
        model.addAttribute("consumos", consumos);
        return "buscarConsumo";
    }

 */

@GetMapping("/buscarConsumo")
public String buscarConsumosEntreFechas(
    @Param("fechaInicio") String fechaInicio,
    @Param("fechaFin") String fechaFin,
    Model model
) {
    List<ClienteInfo> consumos = consumoRepository.findConsumoInfo(fechaInicio, fechaFin);
    model.addAttribute("consumos", consumos);
    return "buscarConsumo";
}

@GetMapping("/buscarConsumoAvanzado")
public String buscarConsumosPorServicio(
    @Param("fechaInicio") String fechaInicio,
    @Param("fechaFin") String fechaFin,
    @Param("nombreServicio") String nombreServicio,
    Model model
) {
    List<ClienteInfoAvanzado> consumos = consumoRepository.findConsumoAvanzado(fechaInicio, fechaFin, nombreServicio);
    model.addAttribute("consumos", consumos);
    return "buscarConsumoAvanzado"; 
} 


    @GetMapping("/req1")
    public String getConsumoPorHabitacion(Model model) {
        model.addAttribute("costoPorHabitaciones", consumoRepository.costoPorHabitacion());
        return "req1";
    }
    

    
}
