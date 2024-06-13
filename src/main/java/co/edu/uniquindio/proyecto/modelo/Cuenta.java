package co.edu.uniquindio.proyecto.modelo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cuenta {
    String nombre;
    String password;
    String email;
    EstadoRegistro estado;

}
