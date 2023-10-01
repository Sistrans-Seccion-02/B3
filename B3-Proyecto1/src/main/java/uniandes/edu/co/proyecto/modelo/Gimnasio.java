package uniandes.edu.co.proyecto.modelo;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="gimnasios")
@Entity
public class Gimnasio extends Servicio{
    private int capacidad;
    private int maquinas;
    private Date horaInicio;
    private Date horaFinal;
    
    public Gimnasio(int capacidad, int maquinas, Date horaInicio, Date horaFinal) {
        this.capacidad = capacidad;
        this.maquinas = maquinas;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public Gimnasio()
    {;}

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(int maquinas) {
        this.maquinas = maquinas;
    }

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

    
    
}
