package co.edu.uniquindio.proyecto.modelo;

import java.time.LocalTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Horario {
    LocalTime horaInicio;
    String dia;
    LocalTime horaFin;

}
