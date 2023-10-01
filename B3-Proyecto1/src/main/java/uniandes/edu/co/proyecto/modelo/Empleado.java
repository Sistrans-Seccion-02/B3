package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="Empleados")
@Entity
public class Empleado extends Usuario{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String cargo;
    private String nombre;

    public Empleado(String cargo, String nombre){
        this.cargo = cargo;
        this.nombre=nombre;
    }

    public Empleado()
    {;}

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
