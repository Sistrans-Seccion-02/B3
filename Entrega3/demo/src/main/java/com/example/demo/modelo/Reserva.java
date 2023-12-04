package com.example.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "Reservas")
public class Reserva {

    @Id
    private String id;

    @Field("idreserva")
    private Integer idReserva;

    @Field("nPersonas")
    private Integer numeroPersonas;

    @Field("fechaEntrada")
    private String fechaEntrada;

    @Field("fechaSalida")
    private String fechaSalida;

    private List<Usuario> usuario;

    private Integer habitacion;

    // Constructor vacío necesario para Spring Boot
    public Reserva() {
    }

    // Constructor con parámetros
    public Reserva(Integer idReserva, Integer numeroPersonas, String fechaEntrada, String fechaSalida, List<Usuario> usuario, Integer habitacion) {
        this.idReserva = idReserva;
        this.numeroPersonas = numeroPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.usuario = usuario;
        this.habitacion = habitacion;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(Integer numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public Integer getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Integer habitacion) {
        this.habitacion = habitacion;
    }

    // toString
    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", idReserva=" + idReserva +
                ", numeroPersonas=" + numeroPersonas +
                ", fechaEntrada='" + fechaEntrada + '\'' +
                ", fechaSalida='" + fechaSalida + '\'' +
                ", usuario=" + usuario +
                ", habitacion=" + habitacion +
                '}';
    }

    // Clase Usuario
    public static class Usuario {
        
        @Field("idusuario")
        private Integer idUsuario;

        private String nombre;
        private String email;
        private String usuario;
        private String contraseña;

        // Constructor vacío
        public Usuario() {
        }

        // Constructor con parámetros
        public Usuario(Integer idUsuario, String nombre, String email, String usuario, String contraseña) {
            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.email = email;
            this.usuario = usuario;
            this.contraseña = contraseña;
        }

        // Getters y setters
        public Integer getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(Integer idUsuario) {
            this.idUsuario = idUsuario;
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

        // toString
        @Override
        public String toString() {
            return "Usuario{" +
                    "idUsuario=" + idUsuario +
                    ", nombre='" + nombre + '\'' +
                    ", email='" + email + '\'' +
                    ", usuario='" + usuario + '\'' +
                    ", contraseña='" + contraseña + '\'' +
                    '}';
        }
    }
}
