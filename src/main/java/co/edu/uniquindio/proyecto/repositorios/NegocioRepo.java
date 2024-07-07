package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.EstadoNegocio;
import co.edu.uniquindio.proyecto.modelo.Negocio;
import co.edu.uniquindio.proyecto.modelo.TipoNegocio;
import co.edu.uniquindio.proyecto.modelo.Ubicacion;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {
    Optional<Negocio> findById(String id);
    Optional<Negocio> findByNombre(String nombre);
    List<Negocio> findByEstadoNegocio(EstadoNegocio estadoNegocio);
    List<Negocio> findByUbicacion(Ubicacion ubicacion);
    List<Negocio> findByTipoNegocio(TipoNegocio tipoNegocio);
    List<Negocio> findByNombreContaining(String nombre);
    List<Negocio> findByNombreContainingAndTipoNegocio(String nombre,TipoNegocio tipoNegocio);
    List<Negocio> findByNombreContainingAndUbicacion(String nombre,Ubicacion ubicacion);
    List<Negocio> findByNombreContainingAndTipoNegocioAndUbicacion(String nombre,TipoNegocio tipoNegocio,Ubicacion ubicacion);
    List<Negocio> findByCodigoCliente(String codigo);

    @Aggregation(pipeline = {
            "{ $sort: { calificacion: -1 } }",
            "{ $limit: 5 }"
    })
    List<Negocio> findTop5ByBestCalificacion();

    boolean existsNegociosByNombre(String nombre);
}