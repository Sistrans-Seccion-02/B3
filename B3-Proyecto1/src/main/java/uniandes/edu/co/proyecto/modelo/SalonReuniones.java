package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="salon_de_reuniones")
@Entity
public class SalonReuniones extends Servicio{

private int capacidad;
private int costoAdicional;
private int costo;

public SalonReuniones(int capacidad, int costoAdicional, int costo) {
    this.capacidad = capacidad;
    this.costoAdicional = costoAdicional;
    this.costo = costo;
}
public SalonReuniones()
{;}

public int getCapacidad() {
    return capacidad;
}

public void setCapacidad(int capacidad) {
    this.capacidad = capacidad;
}

public int getCostoAdicional() {
    return costoAdicional;
}

public void setCostoAdicional(int costoAdicional) {
    this.costoAdicional = costoAdicional;
}

public int getCosto() {
    return costo;
}

public void setCosto(int costo) {
    this.costo = costo;
}

    
}
