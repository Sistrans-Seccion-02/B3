package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Table(name="productos_supermercado")
@Entity
public class ProductoSupermercado {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private int costo;

    @ManyToOne
    @JoinColumn(name="idServicio", referencedColumnName = "id")
    private Supermercado idServicio;

    public ProductoSupermercado(String nombre, int costo, Supermercado idServicio) {
        this.nombre = nombre;
        this.costo = costo;
        this.idServicio = idServicio;
    }

    public ProductoSupermercado()
    {;}

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

    public Supermercado getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Supermercado idServicio) {
        this.idServicio = idServicio;
    }

    

}
