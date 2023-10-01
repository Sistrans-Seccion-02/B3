package uniandes.edu.co.proyecto.modelo;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="piscinas")
@Entity
public class Piscina extends Servicio{

    private Date horaInicio;
    private Date horaFinal;
    private int capacidad;
    private float profundidad;
    
    public Piscina(int id, Date horaInicio, Date horaFinal, int capacidad, float profundidad) {
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.capacidad = capacidad;
        this.profundidad = profundidad;
    }

    public Piscina()
    {;}

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(float profundidad) {
        this.profundidad = profundidad;
    }
    
    
    
    
}
