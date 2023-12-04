package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Reserva;

public  interface ReservaRepository extends MongoRepository<Reserva,Integer>  {

    List<Reserva> findByidreserva(Integer idreserva);

    public class Requerimeinto2{
        String habitacion;
        Long indiceocupacion;
    
        public Requerimeinto2(String habitacion, Long indiceocupacion){
            this.habitacion=habitacion;
            this.indiceocupacion=indiceocupacion;
        }

        public String gethabitacion(){
            return habitacion;
        }
        public void sethabitacion(String habitacion){
            this.habitacion=habitacion;
        }

        public Long getindiceocupacion(){
            return indiceocupacion;
        }

        public void setindiceocupacion(Long indiceocupacion){
            this.indiceocupacion=indiceocupacion;
        }
    }
@Aggregation(pipeline = {
    "{$match: {'fechaEntrada': { $gte: '2023-01-01' }}}",
    "{$group: {_id: '$habitacion',cantidad: { $sum: 1 }}}",
    "{$project: {'habitacion': '$_id', indiceocupacion: {$divide: ['$cantidad', 365]}}}",
    "{$project: {'habitacion': 1, 'indiceocupacion': { $multiply: ['$indiceocupacion', 100] }}}"
})
List<Requerimeinto2> indiceocupacion();

}

