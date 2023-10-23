package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.ReservaServicio;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ReservaServicioRepository extends JpaRepository<ReservaServicio, Integer> {
    
    @Query(value="SELECT * FROM reservas_servicio", nativeQuery = true)
    Collection<ReservaServicio> darReservasServicio();

    @Query(value = "SELECT * FROM reservas_servicio WHERE id= : id", nativeQuery= true)
    ReservaServicio darReservaServicio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas_servicio (fecha, hora, idServicio, habitacion) VALUES (B3-Proyecto1_sequence.nextval, :fecha, :hora, :idServicio, :habitacion)", nativeQuery = true)
    void insertarReserva(@Param("fecha")String fecha, @Param("hora")String hora, @Param("idServicio")Servicio idServicio, @Param("habitacion")Habitacion habitacion);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas_servicio SET fecha=:fecha, hora=:hora, idServicio=:idServicio, habitacion=:habitacion WHERE id=:id", nativeQuery = true)
    void actualizarReserva(
    @Param("id") int id,
    @Param("fecha") String fecha,
    @Param("hora") String hora,
    @Param("idServicio") Servicio servicio,
    @Param("habitacion") Habitacion habitacion
);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM reservas_servicio WHERE id=:id", nativeQuery = true)
    void eliminarReserva(@Param("id") int id);

}