package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Internet;

public interface InternetRepository extends JpaRepository<Internet, Integer> {
    
    @Query(value="SELECT * FROM internets", nativeQuery = true)
    Collection<Internet> darInternets();

    @Query(value = "SELECT * FROM internets WHERE id= : id", nativeQuery= true)
    Internet darInternet(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO internets (capacidad) VALUES (B3-Proyecto1_sequence.nextval, :capacidad)", nativeQuery = true)
    void insertarInternet(@Param("capacidad")int capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE internets SET capacidad=:capacidad WHERE id=:id", nativeQuery = true)
    void actualizarInternet(@Param("id") int id, @Param("capacidad")int capacidad);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM internets WHERE id=:id", nativeQuery = true)
    void eliminarInternet(@Param("id") int id); 
    
}