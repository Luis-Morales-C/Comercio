package co.edu.uniquindio.proyecto.modelo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("negocios")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Negocio {
    @Id
    String codigoNegocio;
    String codigoCliente;
    String nombre;
    String descripcion;
    EstadoNegocio estadoNegocio;
    TipoNegocio tipoNegocio;
    Ubicacion ubicacion;
    List<String> telefonos;
    List<Horario> horarios;
    List<String> imagenes;
    float calificacion;
    List<HistorialRevision> historialRevisiones;
    List<Comentario> listaComentarios;

}
