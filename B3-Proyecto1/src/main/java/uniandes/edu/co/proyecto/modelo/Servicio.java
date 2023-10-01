package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@MappedSuperclass
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    public Servicio(Integer id) {
        this.id = id;
    }

    public Servicio()
    {;}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

}
