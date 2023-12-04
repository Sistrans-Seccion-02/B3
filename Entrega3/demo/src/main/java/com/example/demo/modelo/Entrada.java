package com.example.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Entradas") // Asegúrate de que el nombre de la colección coincida con tu base de datos
public class Entrada {

    @Id
    private String id; // Si el ID es un ObjectId en tu base de datos, puedes usar String aquí para representarlo.

    private Integer identrada;
    private Integer reserva;

    // Constructor vacío necesario para Spring Boot
    public Entrada() {
    }

    // Constructor con parámetros
    public Entrada(Integer identrada, Integer reserva) {
        this.identrada = identrada;
        this.reserva = reserva;
    }

    // Getters y setters para acceder y modificar las propiedades
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdEntrada() {
        return identrada;
    }

    public void setIdEntrada(Integer identrada) {
        this.identrada = identrada;
    }

    public Integer getReserva() {
        return reserva;
    }

    public void setReserva(Integer reserva) {
        this.reserva = reserva;
    }

    // Método toString para imprimir la información de la entrada
    @Override
    public String toString() {
        return "Entrada{" +
                "id='" + id + '\'' +
                ", identrada=" + identrada +
                ", reserva=" + reserva +
                '}';
    }
}
