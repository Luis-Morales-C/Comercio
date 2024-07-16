package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.Horario;
import co.edu.uniquindio.proyecto.modelo.TipoNegocio;
import co.edu.uniquindio.proyecto.modelo.Ubicacion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.util.List;

public record ActualizarNegocioDTO(
        @NotBlank @Id String codigoNegocio,
        @NotBlank String nombre,
        @NotBlank String descripcion,
        @NotNull TipoNegocio tipoNegocio,
        @NotNull Ubicacion ubicacion,
        @NotEmpty List<String> telefonos,
        @NotEmpty List<Horario> horarios,
        @NotEmpty List<String> imagenes

) {
}
