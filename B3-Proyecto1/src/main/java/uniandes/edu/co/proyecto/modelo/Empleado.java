package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="Empleados")
@Entity
public class Empleado extends Usuario{


    private String cargo;


    public Empleado(){
        ;
    }



    public Empleado(String nombre, String cargo){
        super(nombre);
        this.cargo = cargo;
    
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


}
