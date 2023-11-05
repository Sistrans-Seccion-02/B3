package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Table(name="restaurantes")
@Entity
public class Restaurante extends Servicio{




private String nombre;

private Integer capacidad;

private String estilo;
//falta plato(relacion)


public Restaurante()
{;}


public Restaurante(String nombre, Integer capacidad, String estilo) {
    this.nombre = nombre;
    this.capacidad = capacidad;
    this.estilo = estilo;
}


public String getNombre() {
    return nombre;
}


public void setNombre(String nombre) {
    this.nombre = nombre;
}


public Integer getCapacidad() {
    return capacidad;
}


public void setCapacidad(Integer capacidad) {
    this.capacidad = capacidad;
}


public String getEstilo() {
    return estilo;
}


public void setEstilo(String estilo) {
    this.estilo = estilo;
}



}
