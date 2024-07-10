package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.DetalleNegocioDTO;
import co.edu.uniquindio.proyecto.modelo.Negocio;

public interface ModeradorServicio {
    void aprobarNegocio(DetalleNegocioDTO detalleNegocioDTO) throws Exception;
    void revisarNegocio(Negocio negocio);
}
