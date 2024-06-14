package co.edu.uniquindio.proyecto.modelo;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.List;
import lombok.*;

@Document("moderadores")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Moderador extends Cuenta implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    String codigo;

    public Moderador(String nombre, String password, String email, EstadoRegistro estado) {
        super(nombre, password, email, estado);
    }
}
