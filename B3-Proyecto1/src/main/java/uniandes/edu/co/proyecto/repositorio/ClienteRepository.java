package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Usuario;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


<<<<<<< HEAD


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
  

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
=======
    @Query(value = "SELECT * FROM clientes WHERE id_cliente = :idCliente", nativeQuery = true)
    Cliente darCliente(@Param("idCliente") int idCliente);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes ( nombre, id_cliente) VALUES (:nombre, :idCliente)", nativeQuery = true)
    void registrarCliente(
        @Param("nombre") String nombre, 
        @Param("idCliente") int idCliente
>>>>>>> ed65209 (ultimooo)


    @Modifying
    @Transactional
<<<<<<< HEAD
    @Query(value="DELETE FROM clientes WHERE id=:id", nativeQuery = true)
    void eliminarCliente(@Param("id") Integer id);
=======
    @Query(value = "UPDATE clientes SET nombre=:nombre WHERE id_cliente=:idCliente", nativeQuery = true)
    void actualizarCliente(
        @Param("idCliente") int idCliente,
        @Param("nombre") String nombre
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE id_cliente=:idCliente", nativeQuery = true)
    void eliminarCliente(@Param("idCliente") int idCliente);
>>>>>>> ed65209 (ultimooo)
}
