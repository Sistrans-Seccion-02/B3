package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {
    
    @Query(value="SELECT * FROM piscinas", nativeQuery = true)
    Collection<Piscina> darPiscinas();

    @Query(value = "SELECT * FROM piscinas WHERE id= : id", nativeQuery= true)
    Piscina darPiscina(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO piscinas (horaIncio, horaFinal, capacidad, profundidad) VALUES (B3-Proyecto1_sequence.nextval, :horaInicio, :horaFinal, :capacidad, :profundidad)", nativeQuery = true)
    void insertarPiscina(@Param("horaInicio")Date horaInicio, @Param("horaFinal")Date horaFinal, @Param("capacidad")int capacidad, @Param("profundidad") float profundidad);


    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET horaInicio=:horaFinal, horaFinal=:horaFinal, capacidad=:capacidad, pronfundidad=: pronfundidad WHERE id=:id", nativeQuery = true)
    void actualizarPiscina(@Param("id") int id, @Param("horaInicio")Date horaInicio, @Param("horaFinal")Date horaFinal, @Param("capacidad")int capacidad, @Param("profundidad") float profundidad);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM piscinas WHERE id=:id", nativeQuery = true)
    void eliminarPiscina(@Param("id") int id); 
    
}