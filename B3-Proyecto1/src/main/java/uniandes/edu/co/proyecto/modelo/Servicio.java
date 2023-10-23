package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;


@Entity
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id_servicio;

    private String tipo;


    

    public Servicio(Integer id_servicio, String tipo) {
        this.id_servicio = id_servicio;
        this.tipo = tipo;
       
    }

    public Servicio()
    {;}

    public Integer getId() {
        return id_servicio;
    }

    public void setId(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    

    

    
    

}
