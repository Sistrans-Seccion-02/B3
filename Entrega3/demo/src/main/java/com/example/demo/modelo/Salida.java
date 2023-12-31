package com.example.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "salidas")
public class Salida {

    @Id
    private String id;

    @Field("fecha")
    private String fecha;

    @DBRef
    @Field("consumos")
    private List<Consumo> consumos;

    public Salida(){}

    public Salida(String fecha, List<Consumo> consumos){
        this.fecha = fecha;
        this.consumos = consumos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Consumo> getConsumos() {
        return consumos;
    }

    public void setConsumos(List<Consumo> consumos) {
        this.consumos = consumos;
    }

    public void addConsumo(Consumo cons){
        consumos.add(cons);
    }
    
}
