package com.example.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "usuarios")
public class Usuario {
    @Id
    public Integer idusuario;
    
    private String nombre;
    
    private String email;
    
    private String usuario;
   
    private String contrasena;

    public Usuario(){}

    public Usuario(Integer idusuario, String nombre, String email, String usuario, String contrasena){
        this.idusuario=idusuario;
        this.nombre=nombre;
        this.email=email;
        this.usuario=usuario;
        this.contrasena=contrasena;
    }

    public Integer getidusuario(){
        return idusuario;
    }

    public void setidusuario(Integer idusuario){
        this.idusuario=idusuario;
    }

    public String getnombre(){
        return nombre;
    }

    public void setnombre(String nombre){
        this.nombre=nombre;
    }

    public String getemail(){
        return email;
    }

    public void setemail(String email){
        this.email=email;
    }

    public String getusuario(){
        return usuario;
    }

    public void setusuario(String usuario){
        this.usuario=usuario;
    }

    public String getcontrasena(){
        return contrasena;
    }

    public void setcontrasena(String contrasena){
        this.contrasena=contrasena;
    }

    


    
}
