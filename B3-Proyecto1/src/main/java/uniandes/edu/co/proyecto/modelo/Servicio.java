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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_servicio;
    private String tipo;
    private Integer id_reserva;


    

    public Servicio(Integer id_servicio, String tipo, Integer id_reserva) {
        this.id_servicio = id_servicio;
        this.tipo = tipo;
        this.id_reserva = id_reserva;
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

    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }

    

    

    
    

}
