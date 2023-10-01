package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.SalonReuniones;

public interface SalonReunionesRepository extends JpaRepository<SalonReuniones, Integer> {
    
    @Query(value="SELECT * FROM salon_de_reuniones", nativeQuery = true)
    Collection<SalonReuniones> darSalonReuniones();

    @Query(value = "SELECT * FROM salon_de_reuniones WHERE id= : id", nativeQuery= true)
    SalonReuniones darSalonReuniones(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO salon_de_reuniones (costo, costoadicional, capacidad) VALUES (B3-Proyecto1_sequence.nextval, :costo, :costoadicional, :capacidad)", nativeQuery = true)
    void insertarSalonReuniones(@Param("costo")int costo,@Param("costoadicional")int costoadicional, @Param("capacidad")int capacidad);


    @Modifying
    @Transactional
    @Query(value = "UPDATE salon_de_reuniones SET costo=:costo, costoadicional=:costoadicional, capacidad=:capacidad WHERE id=:id", nativeQuery = true)
    void actualizarSalonReuniones(@Param("id") int id, @Param("costo")int costo,@Param("costoadicional")int costoadicional, @Param("capacidad")int capacidad);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM salon_de_reuniones WHERE id=:id", nativeQuery = true)
    void eliminarSalonReuniones(@Param("id") int id); 
    
}
