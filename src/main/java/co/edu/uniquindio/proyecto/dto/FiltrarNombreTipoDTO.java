package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.TipoNegocio;
import jakarta.validation.constraints.NotBlank;

public record FiltrarNombreTipoDTO(
        String nombre,
        TipoNegocio tipoNegocio
) {
}
