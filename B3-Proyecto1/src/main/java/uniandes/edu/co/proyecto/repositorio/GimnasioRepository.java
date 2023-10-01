package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer> {
    
    @Query(value="SELECT * FROM gimnasios", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM gimnasio WHERE id= : id", nativeQuery= true)
    Gimnasio darGimnasio(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO gimnasio (capacidad, maquinas, horaInicio, horaFinal) VALUES (B3-Proyecto1_sequence.nextval, :capacidad, :maquinas, :horaInicio, :horaFinal)", nativeQuery = true)
    void insertarGimnasio(@Param("capacidad")int capacidad, @Param("maquinas")int maquinas, @Param("horaInicio")Date horaInicio, @Param("horaFinal")Date horaFinal);


    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET capacidad=:capacidad, maquinas=:maquinas, horaInicio=:horaInicio, horaFinal=:horaFinal WHERE id=:id", nativeQuery = true)
    void actualizarGimnasio(@Param("id") int id, @Param("capacidad")int capacidad, @Param("maquinas")int maquinas, @Param("horaInicio")Date horaInicio, @Param("horaFinal")Date horaFinal);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM gimnasios WHERE id=:id", nativeQuery = true)
    void eliminarGimnasio(@Param("id") int id); 
    
}