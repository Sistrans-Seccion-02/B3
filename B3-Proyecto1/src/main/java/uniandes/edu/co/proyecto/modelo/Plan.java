package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="planes")
@Entity
public class Plan {
    @Id
    private String nombre;
    private String descripcion;
    private Double descuento;
    
    
    
    public Plan(String nombre, String descripcion, Double descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
    }

    public Plan()
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

   

}