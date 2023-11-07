package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int idusuario;
    public String nombre; 
    public String email;
    public String usuario;
    public String contraseña;
    
    @ManyToOne
    @JoinColumn(name="tipousuario", referencedColumnName = "id")
    public TipoUsuario tipousuario;

    public Usuario(int idusuario, String nombre, String email, String usuario, String contraseña,
            TipoUsuario tipousuario) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.email = email;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipousuario = tipousuario;
    }

    public Usuario()
    {;}

    public int getId_usuario() {
        return idusuario;
    }

    public void setId_usuario(int id_usuario) {
        this.idusuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public TipoUsuario gettipousuario() {
        return tipousuario;
    }

    public void settipousuario(TipoUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    

    
   

}