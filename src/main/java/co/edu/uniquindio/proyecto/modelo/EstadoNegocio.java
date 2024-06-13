package co.edu.uniquindio.proyecto.modelo;

import lombok.*;

@Getter
@NoArgsConstructor
@ToString


public enum EstadoNegocio {
    APROBADO,
    RECHAZADO,
    PENDIENTE;
}
