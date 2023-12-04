package com.example.demo.repositorio;
import java.sql.Date;
import java.util.List;

import org.springframework.data.mongodb.core.aggregation.AggregationResults;
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

    public class ClienteInfo {
        private String cliente_nombre;
        private String cliente_email;
        private String fechaConsumo; 
    
        // Constructor actualizado
        public ClienteInfo(String cliente_nombre, String cliente_email, String fechaConsumo) {
            this.cliente_nombre = cliente_nombre;
            this.cliente_email = cliente_email;
            this.fechaConsumo = fechaConsumo;
        }
    
        // Getters y setters 
        public String getCliente_nombre() {
            return cliente_nombre;
        }
    
        public void setCliente_nombre(String cliente_nombre) {
            this.cliente_nombre = cliente_nombre;
        }
    
        public String getCliente_email() {
            return cliente_email;
        }
    
        public void setCliente_email(String cliente_email) {
            this.cliente_email = cliente_email;
        }
    
        public String getFechaConsumo() {
            return fechaConsumo;
        }
    
        public void setFechaConsumo(String fechaConsumo) {
            this.fechaConsumo = fechaConsumo;
        }
    }
    


    @Aggregation(pipeline = {
        "{ $match: { fechaConsumo: { $gte: ?0, $lte: ?1 } } }",
        "{ $lookup: { from: 'Entradas', localField: 'entrada', foreignField: 'identrada', as: 'entrada_info' } }",
        "{ $unwind: { path: '$entrada_info', preserveNullAndEmptyArrays: true } }",
        "{ $lookup: { from: 'Reservas', localField: 'entrada_info.reserva', foreignField: 'idreserva', as: 'reserva_info' } }",
        "{ $unwind: { path: '$reserva_info', preserveNullAndEmptyArrays: true } }",
        "{ $unwind: { path: '$reserva_info.usuario', preserveNullAndEmptyArrays: false } }",
        "{ $project: { fechaConsumo: 1, cliente_nombre: '$reserva_info.usuario.nombre', cliente_email: '$reserva_info.usuario.email', _id: 0 } }"
    })
    List<ClienteInfo> findConsumoInfo(String fechaInicio, String fechaFin);
    


    public class ClienteInfoAvanzado {
        private String cliente_nombre;
        private String cliente_email;
        private int totalConsumos;
        private List<String> fechasConsumo; 

        // Constructor
        public ClienteInfoAvanzado(String cliente_nombre, String cliente_email, int totalConsumos, List<String> fechasConsumo) {
            this.cliente_nombre = cliente_nombre;
            this.cliente_email = cliente_email;
            this.totalConsumos = totalConsumos;
            this.fechasConsumo = fechasConsumo;
        }

        // Getters y setters
        public String getCliente_nombre() {
            return cliente_nombre;
        }

        public void setCliente_nombre(String cliente_nombre) {
            this.cliente_nombre = cliente_nombre;
        }

        public String getCliente_email() {
            return cliente_email;
        }

        public void setCliente_email(String cliente_email) {
            this.cliente_email = cliente_email;
        }

        public int getTotalConsumos() {
            return totalConsumos;
        }

        public void setTotalConsumos(int totalConsumos) {
            this.totalConsumos = totalConsumos;
        }

        public List<String> getFechasConsumo() {
            return fechasConsumo;
        }

        public void setFechasConsumo(List<String> fechasConsumo) {
            this.fechasConsumo = fechasConsumo;
        }


    }

    @Aggregation(pipeline = {
        "{ $match: { fechaConsumo: { $gte: ?0, $lte: ?1 }, 'servicio.nombre': ?2 } }",
        "{ $lookup: { from: 'Entradas', localField: 'entrada', foreignField: 'identrada', as: 'entrada_info' } }",
        "{ $unwind: { path: '$entrada_info', preserveNullAndEmptyArrays: true } }",
        "{ $lookup: { from: 'Reservas', localField: 'entrada_info.reserva', foreignField: 'idreserva', as: 'reserva_info' } }",
        "{ $unwind: { path: '$reserva_info', preserveNullAndEmptyArrays: true } }",
        "{ $unwind: { path: '$reserva_info.usuario', preserveNullAndEmptyArrays: false } }",
        "{ $group: { _id: { cliente_email: '$reserva_info.usuario.email', cliente_nombre: '$reserva_info.usuario.nombre' }, totalConsumos: { $sum: 1 }, fechas: { $push: '$fechaConsumo' } } }",
        "{ $sort: { '_id.cliente_nombre': 1, totalConsumos: -1, 'fechas': 1 } }",
        "{ $project: { cliente_nombre: '$_id.cliente_nombre', cliente_email: '$_id.cliente_email', totalConsumos: 1, fechasConsumo: '$fechas', _id: 0 } }"
    })
    List<ClienteInfoAvanzado> findConsumoAvanzado(String fechaInicio, String fechaFin, String nombreServicio);
    


}
