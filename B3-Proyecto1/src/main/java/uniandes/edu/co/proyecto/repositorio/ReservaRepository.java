package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Checkin;
import uniandes.edu.co.proyecto.modelo.Checkout;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Plan;
import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    
    @Query(value="SELECT * FROM reservas", nativeQuery = true)
    Collection<Reserva> darReservas();

    @Query(value = "SELECT * FROM reservas WHERE id= : id", nativeQuery= true)
    Reserva darReserva(@Param("id") int id);

   
    

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas (responsable, tipoPlan, fechaEntrada, fechaSalida, numPersonas) VALUES (:responsable, :tipoPlan, :fechaEntrada, :fechaSalida, :numPersonas)", nativeQuery = true)
    void insertarReserva(@Param("responsable") Cliente responsable, @Param("tipo") Plan tipoPlan, @Param("fechaEntrada") Checkin fechaEntrada, @Param("fechaSalida") Checkout fechaSalida, @Param("numPersonas") int numPersonas);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET tipo=:tipo, fechaEntrada=:fechaEntrada, fechaSalida=: fechaSalida, responsable=:responsable, nombre_hotel=:nombre_hotel, planReserva=:planReserva, id_cliente=:id_cliente, checkin_id=:checkin_id, checkout_id =:checkout_id  WHERE id=:id", nativeQuery = true)
    void actualizarReserva(@Param("id") int id, @Param("responsable") Cliente responsable, @Param("tipo") Plan tipoPlan, @Param("fechaEntrada") Checkin fechaEntrada, @Param("fechaSalida") Checkout fechaSalida, @Param("numPersonas") int numPersonas);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM reservas WHERE id=:id", nativeQuery = true)
    void eliminarReserva(@Param("id") int id);

}