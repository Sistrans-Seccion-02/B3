package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository.Req10;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public interface Req9{
        String getIDUSUARIO();
        String getNOMBRE();
        String getEMAIL();
        Integer getVECESSERVICIO();
    }
    


    @Query(value="SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE id= : id", nativeQuery= true)
    Usuario darUsuarioID(@Param("id") Integer id);
   

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (nombre, email, usuario, contraseña, tipo) VALUES (B3-Proyecto1_sequence.nextval, :nombre, :email, :usuario, :contraseña, :tipo)", nativeQuery = true)
    void insertarUsuario(@Param("nombre") String nombre, @Param("email") String email, @Param("usuario") String usuario,  @Param("contraseña") String contraseña, @Param("tipo") TipoUsuario tipo);
   
    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nombre=:nombre, tipoDocumento=:tipoDocumento, email=:email, usuario=:usuario, contraseña=:contraseña, tipo=:tipo  WHERE id=:id", nativeQuery = true)
    void actualizarUsuario(@Param("id") int id,@Param("nombre") String nombre, @Param("email") String email, @Param("usuario") String usuario,  @Param("contraseña") String contraseña, @Param("tipo") TipoUsuario tipo);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM usuarios WHERE id=:id", nativeQuery = true)
    void eliminarUsuario(@Param("id") Integer id);


   @Query(value = "SELECT u.idusuario, u.nombre, u.email, COUNT(u.idusuario) as VECESSERVICIO\n" + //
           "FROM reservas r\n" + //
           "INNER JOIN usuarios u ON (r.idusuario = u.idusuario)\n" + //
           "INNER JOIN consumos c ON(c.nHabitacion = r.nHabitacion)\n" + //
           "INNER JOIN reservasservicio rs ON(rs.nHabitacion = r.nHabitacion)\n" + //
           "WHERE c.idservicio = :idservicio\n" + //
           "AND rs.idservicio = :idservicio\n" + //
           "AND (rs.fecha < :fechafin and rs.fecha > :fechain)\n" + //
           "GROUP BY u.idusuario, u.nombre, u.email\n" + //
           "ORDER BY COUNT(u.idusuario) DESC",
            nativeQuery = true)
    Collection<Req9> usuariosServicios(@Param("idservicio") int id, @Param("fechain") String inicio, @Param("fechafin") String fin);

    



}