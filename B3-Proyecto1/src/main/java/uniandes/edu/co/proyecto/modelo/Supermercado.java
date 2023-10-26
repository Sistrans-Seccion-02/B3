package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Table(name="supermercados")
@Entity
public class Supermercado extends Servicio{

    private String nombre;

    public Supermercado(String nombre) {
        this.nombre = nombre;
    }

    public Supermercado()
    {;}


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
