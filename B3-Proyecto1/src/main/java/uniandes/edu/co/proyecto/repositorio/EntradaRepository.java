package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Entrada;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
    
    @Query(value="SELECT * FROM entradas", nativeQuery = true)
    Collection<Entrada> darEntradas();

    @Query(value = "SELECT * FROM entradas WHERE idReserva= : idReserva", nativeQuery= true)
    Entrada darEntrada(@Param("idReserva") Reserva id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO entradas (idUsuario) VALUES (B3-Proyecto1_sequence.nextval, :idUsuario)", nativeQuery = true)
    void insertarEntrada(@Param("idUsuario")Usuario idUsuario);


    @Modifying
    @Transactional
    @Query(value = "UPDATE entradas SET idUsuario=:idUsuario WHERE idReserva= : idReserva", nativeQuery = true)
    void actualizarEntrada(@Param("idReserva") Reserva id, @Param("idUsuario") Usuario idUsuario);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM entradas WHERE id=:id", nativeQuery = true)
    void eliminarEntrada(@Param("idReserva") Reserva idReserva);


    
}

