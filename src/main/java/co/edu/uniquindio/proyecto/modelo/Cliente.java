package co.edu.uniquindio.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.List;
import lombok.*;

@Document("clientes")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
public class Cliente extends Cuenta implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    @EqualsAndHashCode.Include
    private String cedula;
    private String nickname;
    private String ciudadResidencia;
    private List<String> telefono;
    private List<Negocio> favoritos;


    @Builder
    public Cliente(String nombre, String password, String email, EstadoRegistro estado,String nickname,
                   String cedula, List<String> telefono, List<Negocio> favoritos,String fotoPerfil,String ciudadResidencia){
        super(nombre, password, email, estado,fotoPerfil);
        this.cedula = cedula;
        this.telefono = telefono;
        this.favoritos = favoritos;
        this.nickname = nickname;
        this.ciudadResidencia= ciudadResidencia;
    }
}