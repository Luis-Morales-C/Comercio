package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.exception.ResourceNotFoundException;
import co.edu.uniquindio.proyecto.modelo.EstadoNegocio;
import co.edu.uniquindio.proyecto.modelo.TipoNegocio;
import co.edu.uniquindio.proyecto.modelo.Ubicacion;

import java.util.List;

public interface NegocioServicio {

    String crearNegocio(CrearNegocioDTO crearNegocioDTO)throws Exception;

    void eliminarNegocio(String codigo);

    void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO);

    ItemNegocioDTO obtenerNegocioPorCodigo(String idNegocio) throws ResourceNotFoundException;
    ItemNegocioDTO obtenerNegocioPorNombre(String nombre) throws ResourceNotFoundException;
    List<ItemNegocioDTO> filtrarPorEstado(EstadoNegocio estado);
    List<ItemNegocioDTO> filtrarPorUbicacion(Ubicacion ubicacion);
    List<ItemNegocioDTO> filtrarPorTipoNegocio(TipoNegocio tipoNegocio);
    List<ItemNegocioDTO> filtrarPorNombre(String nombre);
    List<ItemNegocioDTO> filtrarPorNombreYTipoNegocio(FiltrarNombreTipoDTO filtrarNombreYTIpoDTO);
    List<ItemNegocioDTO> filtrarPorNombreYUbicacion(FiltrarNombreUbicacionDTO filtrarPorNombreYUbicacionDTO);
    List<ItemNegocioDTO> filtrarPorNombreYTipoNegocioYUbicacion(FiltrarNombreTipoUbicacionDTO filtrarPorNombreYTipoYUbicacionDTO);
    List<ItemNegocioDTO> listarNegociosPropietario(String codigoCliente);

    //Adicional, listar los mejores 5 negocios
    List<ItemNegocioDTO> listarMejoresNegocios();

    //Top 5 por categoria
    List<ItemNegocioDTO> listarTop5PorCategoria(TipoNegocio tipoNegocio);

}
