package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.SalonConferencias;

public interface SalonConferenciasRepository extends JpaRepository<SalonConferencias, Integer> {
    
    @Query(value="SELECT * FROM salones", nativeQuery = true)
    Collection<SalonConferencias> darSalonConferencias();

    @Query(value = "SELECT * FROM salones WHERE id= : id", nativeQuery= true)
    SalonConferencias darSalonConferencia(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO salones (costo, capacidad) VALUES (B3-Proyecto1_sequence.nextval, :costo, :capacidad)", nativeQuery = true)
    void insertarSalonConferencias(@Param("costo")int costo, @Param("capacidad")int capacidad);


    @Modifying
    @Transactional
    @Query(value = "UPDATE salones SET costo=:costo, capacidad=:capacidad WHERE id=:id", nativeQuery = true)
    void actualizarSalonConferencias(@Param("id") int id, @Param("costo")int costo, @Param("capacidad")int capacidad);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM salones WHERE id=:id", nativeQuery = true)
    void eliminarSalonConferencias(@Param("id") int id); 
    
}
