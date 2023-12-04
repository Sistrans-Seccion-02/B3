package com.example.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "entradas")
public class Entrada {
    @Id
    public String identrada;

    @DBRef
    public List<Reserva> reserva;

    public Entrada(){}

    public Entrada(String identrada, List<Reserva> reserva){
        this.identrada=identrada;
        this.reserva=reserva;
    }

    public String getidentrada(){
        return identrada;
    }

    public void setidentrada(String identrada){
        this.identrada=identrada;
    }

    public List<Reserva> getreserva(){
        return reserva;
    }

    public void setreserva(List<Reserva> reserva){
        this.reserva=reserva;
    }


    
}
