package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Usuario;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteUsuarioRepository extends JpaRepository<Cliente, Integer> {
  

    @Query(value="SELECT * FROM clientes", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM clientes WHERE id= : id", nativeQuery= true)
    Usuario darClienteID(@Param("id") Integer id);
   

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes (id, numAcompañantes) VALUES (:id, :numAcompañantes)", nativeQuery = true)
    void insertarCliente( @Param("numAcompañantes") Integer numAcompañantes) ;
   
    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET  numAcompañantes=:numAcompañantes WHERE id=:id", nativeQuery = true)
    void actualizarCliente(@Param("id") int id, @Param("numAcompañantes") Integer numAcompañantes);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM clientes WHERE id=:id", nativeQuery = true)
    void eliminarCliente(@Param("id") Integer id);
}