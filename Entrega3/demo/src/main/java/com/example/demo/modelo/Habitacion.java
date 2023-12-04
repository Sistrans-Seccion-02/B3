package com.example.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="habitaciones")
public class Habitacion {
    @Id
    private Integer nhabitacion;
    
    private List<TipoHabitacionEmbedded> tipoHabitacion;
    
    public Habitacion(){}

    public Habitacion(Integer nhabitacion, List<TipoHabitacionEmbedded>tipoHabitacion){
        this.nhabitacion=nhabitacion;
        this.tipoHabitacion=tipoHabitacion;
    }

    

    public Integer getNhabitacion(){
        return nhabitacion;
    }
    
    public void setNhabitacion(Integer nhabitacion){
        this.nhabitacion=nhabitacion;
    }

    public List<TipoHabitacionEmbedded> getTipoHabitacion(){
        return tipoHabitacion;
    }
    
    public void setTipoHabitacion(List<TipoHabitacionEmbedded> tipoHabitacion){
        this.tipoHabitacion=tipoHabitacion;
    }

    public void addTipoHabitacion(TipoHabitacionEmbedded tipohabitacion){
        this.tipoHabitacion.add(tipohabitacion);
    }


}
