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
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.DiscriminatorColumn;


@Entity
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idservicio")
    private Integer idservicio;

   
    private String tipo;

    public Servicio(Integer idservicio, String tipo) {
        this.idservicio = idservicio;
        this.tipo = tipo;
       
    }

    public Servicio()
    {;}

    public Integer getId() {
        return idservicio;
    }

    public void setId(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



}
