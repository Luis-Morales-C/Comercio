package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.EstadoNegocio;

public record DetalleNegocioDTO(
        String codigoNegocio,
        EstadoNegocio estadoNegocio
) {
}
