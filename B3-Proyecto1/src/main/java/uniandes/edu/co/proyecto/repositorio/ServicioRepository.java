package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    public interface Req2 {
        String getNOMBRE();
        String getDTYPE();
        int getVECESPEDIDO();
    }

    public interface Req4 {
        String getNOMBRE();
        String getDTYPE();
    }

    
    @Query(value="SELECT * FROM servicios", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM servicios WHERE id= : id", nativeQuery= true)
    Servicio darServicio(@Param("id") int id_servicio);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO servicios (tipo) VALUES (B3-Proyecto1_sequence.nextval, :dtype, :nombre, :costoservicio)", nativeQuery = true)
    void insertarServicio(@Param("dtype")String tipo, @Param("nombre")String nombre, @Param("costoservicio")int costoservicio);


    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET tipo=:tipo WHERE id=:id", nativeQuery = true)
    void actualizarServicio(@Param("id") int id_servicio, @Param("tipo")String tipo);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM servicios WHERE id=:id", nativeQuery = true)
    void eliminarServicio(@Param("id") int id_servicio); 

    @Query(value= "SELECT s.NOMBRE, s.DTYPE, count(c.idconsumo) AS VECESPEDIDO  "+//
                "FROM servicios s "+//
                "RIGHT JOIN consumos c ON(s.idservicio = c.idservicio) "+//
                "GROUP BY s.idservicio, s.nombre, s.dtype, s.costoservicio, s.capacidad, s.estilo, s.hora_final, s.hora_inicio, s.maquinas, s.costo, s.duracion "+//
                "ORDER BY count(c.idconsumo) DESC "+//
                "FETCH FIRST 20 ROWS ONLY",
                nativeQuery=true)
    Collection<Req2> top20servicios();

    @Query(value="SELECT s.idservicio, s.nombre, s.dtype, s.costoservicio, s.capacidad, s.estilo, s.hora_final, s.hora_inicio, s.maquinas, s.costo, s.duracion\n" + //
            "FROM servicios s \n" + //
            "JOIN consumos c ON(s.idservicio = c.idservicio)\n" + //
            "JOIN reservasservicio r ON(r.idservicio = s.idservicio)\n" + //
            "WHERE (s.costoservicio < :costosup\n" + //
            "AND s.costoservicio > :costoinf)\n" + //
            "AND\n" + //
            "(c.nHabitacion = :nhabitacion)\n" + //
            "AND\n" + //
            "(r.fecha > :fechainf AND r.fecha < :fechasup \n" + //
            ")\n" + //
            "GROUP BY s.idservicio, s.nombre, s.dtype, s.costoservicio, s.capacidad, s.estilo, s.hora_final, s.hora_inicio, s.maquinas, s.costo, s.duracion\n", nativeQuery = true)
    Collection<Req4> servicioCaracteristica(@Param("nhabitacion") Integer nhabitacion, @Param("fechainf") String fechainf, @Param("fechasup") String fechasup, @Param("costoinf")Integer costoinf, @Param("costosup") Integer costosup );

    
}
