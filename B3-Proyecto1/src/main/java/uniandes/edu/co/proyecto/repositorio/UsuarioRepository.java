package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @Query(value="SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE id= : id", nativeQuery= true)
    Usuario darUsuarioID(@Param("id") Integer id);
   

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (nombre) VALUES (B3-Proyecto1_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre);
   
    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nombre=:nombre WHERE id=:id", nativeQuery = true)
    void actualizarUsuario(@Param("id") int id, @Param("nombre") String nombre);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM usuarios WHERE id=:id", nativeQuery = true)
    void eliminarUsuario(@Param("id") Integer id);



}