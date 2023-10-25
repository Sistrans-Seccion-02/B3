package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.DiscriminatorColumn;


@Entity
@Table(name="servicios")
@DiscriminatorColumn(name="tipo")
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id_servicio")
    private Integer id_servicio;

   
    @Column(name="tipo", insertable=false, updatable=false)
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
