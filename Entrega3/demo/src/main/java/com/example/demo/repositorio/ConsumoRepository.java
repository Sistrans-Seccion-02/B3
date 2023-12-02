package com.example.demo.repositorio;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Consumo;

public interface ConsumoRepository extends MongoRepository<Consumo, String>{

    List<Consumo> findByidconsumo(String idconsumo);

    public class RespuestaGrupo{
        Integer habitacion;
        Long ingresos;

        public RespuestaGrupo(Integer habitacion, Long ingresos){
            this.habitacion = habitacion;
            this.ingresos = ingresos;
        }

        public Integer gethabitacion() {
            return habitacion;
        }

        public void setHabitacion(Integer habitacion) {
            this.habitacion = habitacion;
        }

        public Long getingresos() {
            return ingresos;
        }

        public void setIngresos(Long ingresos) {
            this.ingresos = ingresos;
        }
    }

    @Aggregation(pipeline={"{$unwind: '$servicio'}, {$group: {_id: '$habitacion' , ingresos: { $sum: '$servicio.precio' }}},{$project: {'habitacion':'$_id',ingresos: 1}},{$sort: {ingresos: -1}}" })
    List<RespuestaGrupo> costoPorHabitacion();


}
