package co.edu.uniquindio.proyecto.modelo;

import java.time.LocalDateTime;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class HistorialRevision {
    String descripcion;
    EstadoRegistro estadoRegistro;
    LocalDateTime fecha;
    String codigoModerador;
}
