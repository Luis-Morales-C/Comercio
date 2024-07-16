package co.edu.uniquindio.proyecto.modelo;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.List;
import lombok.*;

@Document("comentarios")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario {
    @Id
    @EqualsAndHashCode.Include
    String codigo;
    LocalDateTime fecha;
    String codigoNegocio;
    String codigoCliente;
    List<String> mensaje;
    List<String> respuesta;
}
