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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_plan;
    private String nombre;
    private String descripcion;
    private Double descuento;
    
    
    public Plan(Integer id_plan, String nombre, String descripcion, Double descuento) {
        this.id_plan = id_plan;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
    } 

    public Plan()
    {;}

    public Integer getId_plan() {
        return id_plan;
    }

    public void setId_plan(Integer id_plan) {
        this.id_plan = id_plan;
    }

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