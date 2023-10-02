package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Checkin;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Gimnasio;

public interface CheckinRepository extends JpaRepository<Checkin, Integer> {
    @Query(value = "SELECT * FROM checkins", nativeQuery = true)
    Collection<Checkin> darCheckins();

    @Query(value = "SELECT * FROM checkins WHERE id = :id", nativeQuery = true)
    Checkin darCheckin(@Param("id") Integer id);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO checkins (fechaEntrada, responsableHotel, responsable ) VALUES (:fechaEntrada, :responsableHotel, :responsable)", nativeQuery = true)
    void insertarCheckin(@Param("fechaEntrada") Date fechaEntrada, @Param("responsable") Cliente responsable, @Param("responsableHotel") Empleado responsableHotel );

    @Modifying
    @Transactional
    @Query(value = "UPDATE checkins SET fechaEntrada = :fechaEntrada, responsableHotel = :responsableHotel, responsable = :responsable   WHERE id = :id", nativeQuery = true)
    void actualizarCheckin(@Param("id") Integer id, @Param("fechaEntrada") Date fechaEntrada, @Param("responsable") Cliente responsable, @Param("responsableHotel") Empleado responsableHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM checkins WHERE id = :id", nativeQuery = true)
    void eliminarCheckin(@Param("id") Integer id);
}