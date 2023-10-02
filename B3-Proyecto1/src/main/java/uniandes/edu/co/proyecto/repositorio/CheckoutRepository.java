package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Checkout;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Empleado;

public interface CheckoutRepository extends JpaRepository<Checkout, Integer> {
    @Query(value = "SELECT * FROM checkouts", nativeQuery = true)
    Collection<Checkout> darCheckins();

    @Query(value = "SELECT * FROM checkouts WHERE id = :id", nativeQuery = true)
    Checkout darCheckout(@Param("id") Integer id);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO checkouts (fechaSalida, responsableHotel, responsable ) VALUES (:fechaSalida, :responsableHotel, :responsable)", nativeQuery = true)
    void insertarCheckout(@Param("fechaSalida") Date fechaSalida, @Param("responsable") Cliente responsable, @Param("responsableHotel") Empleado responsableHotel );

    @Modifying
    @Transactional
    @Query(value = "UPDATE checkouts SET fechaSalida = :fechaSalida, responsableHotel = :responsableHotel, responsable = :responsable   WHERE id = :id", nativeQuery = true)
    void actualizarCheckout(@Param("id") Integer id, @Param("fechaSalida") Date fechaSalida, @Param("responsable") Cliente responsable, @Param("responsableHotel") Empleado responsableHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM checkouts WHERE id = :id", nativeQuery = true)
    void eliminarCheckout(@Param("id") Integer id);
}