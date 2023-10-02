package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Table(name="productos_tienda")
@Entity
public class ProductoTienda {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private int costo;

    @ManyToOne
    @JoinColumn(name="idServicio", referencedColumnName = "id")
    private Tienda idServicio;

    public ProductoTienda(String nombre, int costo, Tienda idServicio) {
        this.nombre = nombre;
        this.costo = costo;
        this.idServicio = idServicio;
    }

    public ProductoTienda()
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

    public Tienda getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Tienda idServicio) {
        this.idServicio = idServicio;
    }

    

}
