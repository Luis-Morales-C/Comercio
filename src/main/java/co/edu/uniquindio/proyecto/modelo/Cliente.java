package co.edu.uniquindio.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.List;
import lombok.*;

@Document("clientes")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Cuenta implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String cedula;
    private String nombre;
    private String email;
    private List<String> telefono;
        private List<Negocio> favoritos;
}