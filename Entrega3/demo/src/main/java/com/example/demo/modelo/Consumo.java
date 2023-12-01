package com.example.demo.modelo;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="consumos")
public class Consumo{
    
        @Id
        private String idconsumo;
        private Integer habitacion;
        private String fechaConsumo;
        private Integer entrada;

        private List<ServicioEmbedded> servicio;
    
        public Consumo(){}

        public Consumo(String idconsumo, Integer habitacion, String fechaConsumo, Integer entrada, List<ServicioEmbedded> servicio){
            this.idconsumo = idconsumo;
            this.habitacion = habitacion;
            this.fechaConsumo = fechaConsumo;
            this.entrada = entrada;
            this.servicio = servicio;
        }

        public String getIdconsumo(){
            return idconsumo;
        }

        public void setIdconsumo(String idconsumo){
            this.idconsumo = idconsumo;
        }

        public Integer getHabitacion(){
            return habitacion;
        }

        public void setHabitacion(Integer habitacion){
            this.habitacion = habitacion;
        }

        public String getFechaConsumo(){
            return fechaConsumo;
        }

        public void setFechaConsumo(String fechaConsumo){
            this.fechaConsumo = fechaConsumo;
        }

        public Integer getEntrada(){
            return entrada;
        }

        public void setEntrada(Integer entrada){
            this.entrada = entrada;
        }

        public List<ServicioEmbedded> getServicio(){
            return servicio;
        }

        public void setServicio(List<ServicioEmbedded> servicio){
            this.servicio = servicio;
        }

        public void addServicio(ServicioEmbedded servicio){
            this.servicio.add(servicio);
        }

}