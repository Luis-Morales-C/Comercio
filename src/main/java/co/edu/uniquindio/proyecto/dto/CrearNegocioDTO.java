package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.Horario;
import co.edu.uniquindio.proyecto.modelo.TipoNegocio;
import co.edu.uniquindio.proyecto.modelo.Ubicacion;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.util.List;

public record  CrearNegocioDTO (

        @NotBlank String codigoCliente,
        @NotBlank String nombre,
        @NotBlank String descripcion,
        @NotBlank TipoNegocio tipoNegocio,
        @NotBlank Ubicacion ubicacion,
        @NotBlank List<String> telefonos,
        @NotBlank List<Horario> horarios,
        @NotBlank List<String> imagenes

){}
