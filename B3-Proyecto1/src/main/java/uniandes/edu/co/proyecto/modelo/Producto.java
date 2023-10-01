package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Table(name="piscina")
@Entity
public class Producto {
    
    @Id
    private String nombre;
    private int costo;

    @JoinColumn(name="idServicio", referencedColumnName = "id")
    private Servicio idServicio;

    public Producto(String nombre, int costo, Servicio idServicio) {
        this.nombre = nombre;
        this.costo = costo;
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    

}
