package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.util.List;

public record ItemNegocioDTO(

        @NotBlank @Id String codigoNegocio,
        @NotBlank String codigoCliente,
        @NotBlank String nombre,
        @NotBlank String descripcion,
        EstadoNegocio estadoNegocio,
        @NotBlank TipoNegocio tipoNegocio,
        @NotBlank Ubicacion ubicacion,
        @NotBlank List<String>telefonos,
        @NotBlank List<Horario> horarios,
        @NotBlank List<String> imagenes,
        float calificacion
) {
}
