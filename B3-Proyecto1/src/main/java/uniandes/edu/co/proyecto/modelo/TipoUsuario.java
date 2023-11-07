package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tiposusuario")
public class TipoUsuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String tipo;
    private String funciones;
    
    public TipoUsuario(int id, String tipo, String funciones) {
        this.id = id;
        this.tipo = tipo;
        this.funciones = funciones;
    }

    public TipoUsuario()
    {;}

    public int getId_usuario() {
        return id;
    }
    public void setId_usuario(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getFunciones() {
        return funciones;
    }
    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    

    
}
