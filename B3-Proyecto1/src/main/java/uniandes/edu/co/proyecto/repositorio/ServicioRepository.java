package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    
    @Query(value="SELECT * FROM servicios", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM servicios WHERE id= : id", nativeQuery= true)
    Servicio darServicio(@Param("id") int id_servicio);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO servicios (tipo) VALUES (B3-Proyecto1_sequence.nextval, :tipo)", nativeQuery = true)
    void insertarServicio(@Param("tipo")String tipo);


    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET tipo=:tipo WHERE id=:id", nativeQuery = true)
    void actualizarServicio(@Param("id") int id_servicio, @Param("tipo")String tipo);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM servicios WHERE id=:id", nativeQuery = true)
    void eliminarServicio(@Param("id") int id_servicio); 
    
}
