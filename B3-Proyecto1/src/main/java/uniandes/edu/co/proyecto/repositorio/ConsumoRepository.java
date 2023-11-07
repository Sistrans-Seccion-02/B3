package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import oracle.sql.DATE;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Entrada;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {

    public interface Req5{
        int getIDCONSUMO();
        String getFECHA();
        int getIDUSUARIO();
        String getNOMBRE();
    }
    public interface Req10{
        int getIDUSUARIO();
        String getNOMBRE();
        String getEMAIL();
    }


    @Query(value="SELECT * FROM consumos", nativeQuery = true)
    Collection<Consumo> darConsumos();
    
    @Query(value = "SELECT * FROM consumos WHERE id = :id", nativeQuery = true)
    Consumo darConsumo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos (idServicio, idReserva, numHabitacion) VALUES (:idServicio, :idReserva, :numHabitacion)", nativeQuery = true)
    void insertarConsumo(
        @Param("idServicio") Servicio id_servicio,
        @Param("idReserva") Entrada id_reserva,
        @Param("numHabitacion") Habitacion numHabitacion
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET idServicio=:idServicio, idReserva=:idReserva, numHabitacion=:numHabitacion WHERE id=:id", nativeQuery = true)
    void actualizarConsumo(
        @Param("id") int id,
        @Param("idServicio") Servicio id_servicio,
        @Param("idReserva") Entrada id_reserva,
        @Param("numHabitacion") Habitacion numHabitacion
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE id=:id", nativeQuery = true)
    void eliminarConsumo(@Param("id") int id);

    @Query(value = "SELECT DISTINCT c.idconsumo, rs.fecha, u.idusuario, u.nombre " +
                    "FROM consumos c " +
                    "JOIN reservas r ON (r.nhabitacion = c.nHabitacion) " +
                    "JOIN servicios s ON (s.idservicio = c.idservicio) " +
                    "JOIN reservasservicio rs ON (rs.idservicio = s.idservicio) " +
                    "JOIN usuarios u ON (u.idusuario = r.idusuario) " +
                    "WHERE u.idusuario = :id " +
                    "AND TO_DATE(rs.fecha, 'MM/DD/YYYY') BETWEEN TO_DATE(:inicio, 'MM/DD/YYYY') AND TO_DATE(:fin, 'MM/DD/YYYY') " +
                    "ORDER BY rs.fecha",
    nativeQuery = true)
    Collection<Req5> filtrarConsumos(@Param("id") int id, @Param("inicio") String inicio, @Param("fin") String fin);



    @Query(value = "SELECT u.idusuario, u.nombre, u.email " +
                "FROM usuarios u " +
                "WHERE u.idusuario NOT IN (" +
                "SELECT r.idusuario " +
                "FROM consumos c " +
                "JOIN reservas r ON r.nHabitacion = c.nHabitacion " +
                "JOIN servicios s ON s.idservicio = c.idservicio " +
                "JOIN reservasservicio rs ON rs.idservicio = s.idservicio " +
                "WHERE s.idservicio = :id AND (rs.fecha > :inicio AND rs.fecha < :fin))",
        nativeQuery = true)
    Collection<Req10> findServicioUsuarioNotIn(@Param("id") int id, @Param("inicio") String inicio, @Param("fin") String fin);

}


