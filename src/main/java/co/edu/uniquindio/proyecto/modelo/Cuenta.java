package co.edu.uniquindio.proyecto.modelo;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cuenta {
    String nombre;
    String password;
    String email;
    EstadoRegistro estado;
    String fotoPerfil;

}
