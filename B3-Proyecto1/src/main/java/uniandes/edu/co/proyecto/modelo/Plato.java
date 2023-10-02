package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Table(name="platos")
@Entity

public class Plato {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private int costo;

    @ManyToOne
    @JoinColumn(name="idRestaurante", referencedColumnName = "id")
    private Restaurante idRestaurante;

    public Plato(String nombre, int costo, Restaurante idRestaurante) {
        this.nombre = nombre;
        this.costo = costo;
        this.idRestaurante = idRestaurante;
    }

    public Plato()
    {
        ;
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

    public Servicio getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Restaurante idRestaurante) {
        this.idRestaurante = idRestaurante;
    }



    
}
