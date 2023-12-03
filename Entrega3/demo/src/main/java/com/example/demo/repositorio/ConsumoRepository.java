package com.example.demo.repositorio;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Consumo;

public interface ConsumoRepository extends MongoRepository<Consumo, String>{

    List<Consumo> findByidconsumo(String idconsumo);

    public class RespuestaGrupo{
        String habitacion;
        int ingresos;

        public RespuestaGrupo(String habitacion, int ingresos){
            this.habitacion = habitacion;
            this.ingresos = ingresos;
        }

        public String gethabitacion() {
            return habitacion;
        }

        public void setHabitacion(String habitacion) {
            this.habitacion = habitacion;
        }

        public int getingresos() {
            return ingresos;
        }

        public void setIngresos(int ingresos) {
            this.ingresos = ingresos;
        }
    }

    @Aggregation(pipeline={"{$unwind: '$servicio'}", "{$group:{_id: '$habitacion', ingresos:{$sum:'$servicio.precio'}}}","{$project: {'habitacion':'$_id',ingresos: 1}}", "{$sort: {ingresos: -1}}" })
    List<RespuestaGrupo> costoPorHabitacion();


}
