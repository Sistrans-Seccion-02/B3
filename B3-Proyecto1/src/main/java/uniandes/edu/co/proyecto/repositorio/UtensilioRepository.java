package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Utensilio;

public interface UtensilioRepository extends JpaRepository<Utensilio, Integer> {
    
    @Query(value="SELECT * FROM utensilios", nativeQuery = true)
    Collection<Utensilio> darUtensilios();

    @Query(value = "SELECT * FROM utensilios WHERE id= : id", nativeQuery= true)
    Utensilio darUtensilios(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO tiendas (devuelto, nombre) VALUES (B3-Proyecto1_sequence.nextval, :devuelto, :nombre)", nativeQuery = true)
    void insertarUtensilio(@Param("devuelto") Boolean devuelto, @Param("nombre")String nombre);


    @Modifying
    @Transactional
    @Query(value = "UPDATE tiendas SET devuelto=:devuelto, nombre=:nombre WHERE id=:id", nativeQuery = true)
    void actualizarUtensilio(@Param("id") int id, @Param("devuelto") Boolean devuelto, @Param("nombre")String nombre);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM tiendas WHERE id=:id", nativeQuery = true)
    void eliminarUtensilio(@Param("id") int id); 
    
}
