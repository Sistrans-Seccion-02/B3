package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    
    @Query(value="SELECT * FROM hoteles", nativeQuery = true)
    Collection<Empleado> darHoteles();

    @Query(value = "SELECT * FROM hoteles WHERE id= : id", nativeQuery= true)
    Hotel darHotelID(@Param("id") Integer id);
   

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hoteles (nombre) VALUES (B3-Proyecto1_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarHotel(@Param("nombre") String nombre, @Param("ubicacion")String ubicacion, @Param("capacidad")int capacidad);
   
    @Modifying
    @Transactional
    @Query(value = "UPDATE hoteles SET nombre=:nombre WHERE id=:id", nativeQuery = true)
    void actualizarHotel(@Param("id") int id, @Param("nombre") String nombre, @Param("ubicacion")String ubicacion, @Param("capacidad")int capacidad);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM hoteles WHERE id=:id", nativeQuery = true)
    void eliminarHotel(@Param("id") Integer id);
    
   
}
