package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.hibernate.annotations.CollectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.ReservaServicio;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ReservaServicioRepository extends JpaRepository<ReservaServicio, Integer> {
    public interface Req8 {
        int getIDSERVICIO();
        int getSEMANA();
        int getANIO();
        int getNUMERODERESERVAS();
        

    }

    @Query(value="SELECT * FROM RESERVASSERVICIO", nativeQuery = true)
    Collection<ReservaServicio> darReservasServicio();

    @Query(value = "SELECT * FROM RESERVASSERVICIO WHERE IDRESERVASERVICIO=: id", nativeQuery= true)
    ReservaServicio darReservaServicio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO RESERVASSERVICIO (fecha, hora, idServicio, habitacion) VALUES (B3-Proyecto1_sequence.nextval, :fecha, :hora, :idServicio, :habitacion)", nativeQuery = true)
    void insertarReserva(@Param("fecha")String fecha, @Param("hora")String hora, @Param("idServicio")Servicio idServicio, @Param("habitacion")Habitacion habitacion);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE RESERVASSERVICIO SET fecha=:fecha, hora=:hora, idServicio=:idServicio, habitacion=:habitacion WHERE IDRESERVASERVICIO=:id", nativeQuery = true)
    void actualizarReserva(
    @Param("id") int id,
    @Param("fecha") String fecha,
    @Param("hora") String hora,
    @Param("idServicio") Servicio servicio,
    @Param("habitacion") Habitacion habitacion
);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM RESERVASSERVICIO WHERE IDRESERVASERVICIO=:id", nativeQuery = true)
    void eliminarReserva(@Param("id") int id);

    @Query(value = "SELECT " +
                    "r.IDSERVICIO, " +
                    "TO_CHAR(TO_DATE(r.FECHA, 'MM/DD/YYYY'), 'IW') AS SEMANA, " +
                    "TO_CHAR(TO_DATE(r.FECHA, 'MM/DD/YYYY'), 'YYYY') AS ANIO , " +
                    "COUNT(r.IDRESERVASERVICIO) AS NUMERODERESERVAS " +
                    "FROM RESERVASSERVICIO r " +
                    "GROUP BY r.IDSERVICIO, TO_CHAR(TO_DATE(r.FECHA, 'MM/DD/YYYY'), 'IW'), TO_CHAR(TO_DATE(r.FECHA, 'MM/DD/YYYY'), 'YYYY') " +
                    "HAVING COUNT(r.IDRESERVASERVICIO) < 10 " +
                    "ORDER BY TO_CHAR(TO_DATE(r.FECHA, 'MM/DD/YYYY'), 'YYYY'), TO_CHAR(TO_DATE(r.FECHA, 'MM/DD/YYYY'), 'IW')",
        nativeQuery = true)
    Collection<Req8> filtrarReservas();

    


}