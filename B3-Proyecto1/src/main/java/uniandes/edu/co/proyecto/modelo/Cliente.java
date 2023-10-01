package uniandes.edu.co.proyecto.modelo;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {

    // Atributos
    private String nombre;
    private String reservaId;  
    private String idCliente;       
    // Constructor
    public Cliente(String nombre, String reservaId, String idCliente) {
        this.nombre = nombre;
        this.reservaId = reservaId;
        this.idCliente = idCliente;
    }

    public Cliente()
    {;}

    // Métodos getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReservaId() {
        return reservaId;
    }

    public void setReservaId(String reservaId) {
        this.reservaId = reservaId;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }


}

