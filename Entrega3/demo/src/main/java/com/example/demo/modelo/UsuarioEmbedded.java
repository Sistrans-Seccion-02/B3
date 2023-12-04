package com.example.demo.modelo;

import org.springframework.data.annotation.Id;

public class UsuarioEmbedded {
    @Id
    public Integer idusuario;
    
    public String nombre;
    
    public String email;
    
    public String usuario;
   
    public String contrasena;

    public UsuarioEmbedded(){}

    public UsuarioEmbedded(Integer idusuario, String nombre, String email, String usuario, String contrasena){
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
