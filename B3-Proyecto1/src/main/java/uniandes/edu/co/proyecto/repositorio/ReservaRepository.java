package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    
    @Query(value="SELECT * FROM reservas", nativeQuery = true)
    Collection<Reserva> darReservas();

    @Query(value = "SELECT * FROM reservas WHERE id= : id", nativeQuery= true)
    Reserva darReserva(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas (tipo, fechaEntrada, fechaSalida, responsable, nombre_hotel, planReserva, id_cliente, checkin_id, checkout_id,) VALUES (B3-Proyecto1_sequence.nextval, :tipo, :fechaEntrada, :fechaSalida, :responsable, :nombre_hotel, :planReserva, :id_cliente, :checkin_id, :checkout_id)", nativeQuery = true)
    void insertarReserva(@Param("tipo")String tipo, @Param("fechaEntrada") Date fechaEntrada, @Param("fechaSalida") Date fechaSalida, @Param("responsable") String responsable, @Param("nombre_hotel") Hotel nombre_hotel);
    // @Param("planReserva")Plan planReserva)
    // @Param("id_cliente")Cliente id_cliente)
    // @Param("checkin_id")Check-In checkin_id)
    // @Param("checkout_id")Check-Out checkout_id)

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET tipo=:tipo, fechaEntrada=:fechaEntrada, fechaSalida=: fechaSalida, responsable=:responsable, nombre_hotel=:nombre_hotel, planReserva=:planReserva, id_cliente=:id_cliente, checkin_id=:checkin_id, checkout_id =:checkout_id  WHERE id=:id", nativeQuery = true)
    void actualizarReserva(@Param("id") int id, @Param("tipo")String tipo, @Param("fechaEntrada") Date fechaEntrada, @Param("fechaSalida") Date fechaSalida, @Param("responsable") String responsable, @Param("nombre_hotel") Hotel nombre_hotel);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM reservas WHERE id=:id", nativeQuery = true)
    void eliminarReserva(@Param("id") int id);

}
