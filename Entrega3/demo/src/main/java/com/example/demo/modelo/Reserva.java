package com.example.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reservas")
public class Reserva {
    @Id
    public Integer idreserva;
    public Integer npersonas;
    public String fechaentrada;
    public String fechasalida;
    public Integer habitacion;


    public List<UsuarioEmbedded> usuario;

    public Reserva(){}

    public Reserva(Integer idreserva, Integer npersonas, String fechaentrada, String fechasalida,  List<UsuarioEmbedded> usuario, Integer habitacion){
        this.idreserva=idreserva;
        this.npersonas=npersonas;
        this.fechaentrada=fechaentrada;
        this.fechasalida=fechasalida;
        this.usuario=usuario;
        this.habitacion=habitacion;
    }

    public Integer getidreserva(){
        return idreserva;
    }
    public void setidreserva(Integer idreserva){
        this.idreserva=idreserva;
    }

    public Integer getnpersonas(){
        return npersonas;
    }
    public void setnpersonas(Integer npersonas){
        this.npersonas=npersonas;
    }

    public String getfechaentrada(){
        return fechaentrada;
    }
    public void setfechaentrada(String fechaentrada){
        this.fechaentrada=fechaentrada;
    }

    public String getfechasalida(){
        return fechasalida;
    }

    public void setfechasalida(String fechasalida){
        this.fechasalida=fechasalida;
    }

    public Integer gethabitacion(){
        return habitacion;
    }
    public void sethabitacion(Integer habitacion){
        this.habitacion=habitacion;
    }

     public List<UsuarioEmbedded> getusuario(){
        return usuario;
    }
    public void setusuario(List<UsuarioEmbedded> usuario){
        this.usuario=usuario;
    }

    public void addusuario(UsuarioEmbedded usuario){
        this.usuario.add(usuario);
    }


    
    


}
