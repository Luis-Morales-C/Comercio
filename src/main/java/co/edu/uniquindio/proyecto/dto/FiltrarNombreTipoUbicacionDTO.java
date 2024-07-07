package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.TipoNegocio;
import co.edu.uniquindio.proyecto.modelo.Ubicacion;

public record FiltrarNombreTipoUbicacionDTO(
        String nombre,
        TipoNegocio tipoNegocio,
        Ubicacion ubicacion
) {
}
