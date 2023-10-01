package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="restaurantes")
@Entity
public class Restaurante extends Servicio{

private String nombre;
private Integer capacidad;
private String estilo;
//falta plato(relacion)

public Restaurante(int id, String nombre, Integer capacidad, String estilo)
{   
    this.nombre = nombre;
    this.capacidad = capacidad;
    this.estilo = estilo;

}

public Restaurante()
{;}

public String getNombre() {
    return nombre;
}

public Integer getCapacidad() {
    return capacidad;
}

public String getEstilo() {
    return estilo;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public void setCapacidad(Integer capacidad) {
    this.capacidad = capacidad;
}

public void setEstilo(String estilo) {
    this.estilo = estilo;
}

    
}
