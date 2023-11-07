package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    


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


    @Query(value="SELECT u.idusuario, u.nombre, u.email, u.usuario, u.contraseña, u.tipousuario \n" + //
            "FROM consumos c\n" + //
            "JOIN reservas r ON (r.nHabitacion = c.nHabitacion)\n" + //
            "JOIN servicios s ON (s.idservicio = c.idservicio)\n" + //
            "JOIN reservasservicio rs ON(rs.idservicio = s.idservicio)\n" + //
            "JOIN usuarios u ON (u.idusuario = r.idusuario)\n" + //
            "WHERE (s.costoservicio < :costosup\n" + //
            "AND s.costoservicio > :costoinf)\n" + //
            "AND\n" + //
            "(rs.fecha > :fechainf AND rs.fecha < :fechasup\n" + //
            ")\n" + //
            "GROUP BY  u.idusuario, u.nombre, u.usuario, u.email, u.contraseña, u.tipousuario\n" + //
            "ORDER BY count(u.idusuario)\n", nativeQuery = true
            )
    Collection<Usuario> usuariosServicios(@Param("fechainf") String fechainf, @Param("fechasup") String fechasup, @Param("costoinf")Integer costoinf, @Param("costosup") Integer costosup);
    



}