package co.edu.uniquindio.proyecto.impl;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.exception.ResourceNotFoundException;
import co.edu.uniquindio.proyecto.modelo.*;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.repositorios.NegocioRepo;
import co.edu.uniquindio.proyecto.servicios.NegocioServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NegocioServicioImpl implements NegocioServicio {
    private final NegocioRepo negocioRepo;
    private final ClienteRepo clienteRepo;

    public NegocioServicioImpl(NegocioRepo negocioRepo, ClienteRepo clienteRepo) {
        this.negocioRepo = negocioRepo;
        this.clienteRepo = clienteRepo;
    }

    @Override
    public String crearNegocio(CrearNegocioDTO crearNegocioDTO)throws Exception {
        if(existNombre(crearNegocioDTO.nombre())){
            throw new Exception("El nombre ya existe");
        }
        Optional<Cliente> cliente=clienteRepo.findByCedula(crearNegocioDTO.codigoCliente());

        if(cliente.isEmpty()){
            throw new Exception("el cliente no existe");
        }

        Cliente cliente1=cliente.get();
        if(cliente1.getEstado()== EstadoRegistro.INACTIVO){
            throw new Exception("El cliente ha sido eliminado");
        }

        Negocio negocio=new Negocio();
        negocio.setCodigoCliente(crearNegocioDTO.codigoCliente());
        negocio.setEstadoNegocio(EstadoNegocio.PENDIENTE);
        negocio.setNombre(crearNegocioDTO.nombre());
        negocio.setDescripcion(crearNegocioDTO.descripcion());
        negocio.setTipoNegocio(crearNegocioDTO.tipoNegocio());
        negocio.setUbicacion(crearNegocioDTO.ubicacion());
        negocio.setTelefonos(crearNegocioDTO.telefonos());
        negocio.setHorarios(crearNegocioDTO.horarios());
        negocio.setImagenes(crearNegocioDTO.imagenes());

        negocioRepo.save(negocio);

        return negocio.getCodigoNegocio();
    }

    @Override
    public void eliminarNegocio(String codigo) {
        Optional<Negocio> optionalNegocio = negocioRepo.findById(codigo);
        if(optionalNegocio.isPresent()){
            Negocio negocio1=optionalNegocio.get();
            negocioRepo.delete(negocio1);
        }else{
            throw new ResourceNotFoundException("El negocio no existe");
        }
    }

    @Override
    public void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception {
        if (negocioRepo.existsById(actualizarNegocioDTO.codigoNegocio())){
            Negocio negocio=negocioRepo.findById(actualizarNegocioDTO.codigoNegocio()).get();
            negocio.setNombre(actualizarNegocioDTO.nombre());
            negocio.setTipoNegocio(actualizarNegocioDTO.tipoNegocio());
            negocio.setDescripcion(actualizarNegocioDTO.descripcion());
            negocio.setHorarios(actualizarNegocioDTO.horarios());
            negocio.setImagenes(actualizarNegocioDTO.imagenes());
            negocio.setTelefonos(actualizarNegocioDTO.telefonos());
            negocio.setUbicacion(actualizarNegocioDTO.ubicacion());

            negocioRepo.save(negocio);
        }
        else{
            throw new Exception("Negocio no existe");
        }
    }

    @Override
    public ItemNegocioDTO obtenerNegocioPorCodigo(String idNegocio) throws ResourceNotFoundException {
        if(negocioRepo.existsById(idNegocio)){
            Negocio negocio = negocioRepo.findById(idNegocio).get();
            return new ItemNegocioDTO(negocio.getCodigoNegocio(),negocio.getCodigoCliente(),
                    negocio.getNombre(),negocio.getDescripcion(),negocio.getEstadoNegocio(),negocio.getTipoNegocio(),
                    negocio.getUbicacion(),negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion());
        }else{
            throw new ResourceNotFoundException("El negocio no existe");
        }

    }

    @Override
    public ItemNegocioDTO obtenerNegocioPorNombre(String nombre) throws ResourceNotFoundException {
      if(negocioRepo.existsNegociosByNombre(nombre)){
         Negocio negocio=negocioRepo.findByNombre(nombre).get();
          return new ItemNegocioDTO(negocio.getCodigoNegocio(),negocio.getCodigoCliente(),
                  negocio.getNombre(),negocio.getDescripcion(),negocio.getEstadoNegocio(),negocio.getTipoNegocio(),
                  negocio.getUbicacion(),negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion());
      }else{
          throw new ResourceNotFoundException("El negocio no existe");
      }
    }

    @Override
    public List<ItemNegocioDTO> filtrarPorEstado(EstadoNegocio estado) {
        List<Negocio> negocios = negocioRepo.findByEstadoNegocio(estado);

        List<ItemNegocioDTO> items=negocios.stream().
                map(negocio-> new ItemNegocioDTO(negocio.getCodigoNegocio(),
                        negocio.getCodigoCliente(),negocio.getNombre(),negocio.getDescripcion(),
                        negocio.getEstadoNegocio(),negocio.getTipoNegocio(),negocio.getUbicacion(),
                        negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion())).toList();

        return items;
    }

    @Override
    public List<ItemNegocioDTO> filtrarPorUbicacion(Ubicacion ubicacion) {
        List<Negocio> negocios=negocioRepo.findByUbicacion(ubicacion);
        List<ItemNegocioDTO> items=negocios.stream()
                .map(negocio-> new ItemNegocioDTO(negocio.getCodigoNegocio(),
                        negocio.getCodigoCliente(),negocio.getNombre(),negocio.getDescripcion(),
                        negocio.getEstadoNegocio(),negocio.getTipoNegocio(),negocio.getUbicacion(),
                        negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion())).toList();
        return items;
    }

    @Override
    public List<ItemNegocioDTO> filtrarPorTipoNegocio(TipoNegocio tipoNegocio) {
        List<Negocio> negocios=negocioRepo.findByTipoNegocio(tipoNegocio);
        List<ItemNegocioDTO> items=negocios.stream()
                .map(negocio-> new ItemNegocioDTO(negocio.getCodigoNegocio(),
                        negocio.getCodigoCliente(),negocio.getNombre(),negocio.getDescripcion(),
                        negocio.getEstadoNegocio(),negocio.getTipoNegocio(),negocio.getUbicacion(),
                        negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion())).toList();
        return items;
    }

    @Override
    public List<ItemNegocioDTO> filtrarPorNombre(String nombre) {
        List<Negocio> negocios=negocioRepo.findByNombreContaining(nombre);
        List<ItemNegocioDTO> items=negocios.stream()
                .map(negocio-> new ItemNegocioDTO(negocio.getCodigoNegocio(),
                        negocio.getCodigoCliente(),negocio.getNombre(),negocio.getDescripcion(),
                        negocio.getEstadoNegocio(),negocio.getTipoNegocio(),negocio.getUbicacion(),
                        negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion())).toList();
        return items;
    }

    @Override
    public List<ItemNegocioDTO> filtrarPorNombreYTipoNegocio(FiltrarNombreTipoDTO filtrarNombreYTIpoDTO) {
        List<Negocio> negocios=negocioRepo.findByNombreContainingAndTipoNegocio(filtrarNombreYTIpoDTO.nombre(),filtrarNombreYTIpoDTO.tipoNegocio());
        List<ItemNegocioDTO> items=negocios.stream()
                .map(negocio-> new ItemNegocioDTO(negocio.getCodigoNegocio(),
                        negocio.getCodigoCliente(),negocio.getNombre(),negocio.getDescripcion(),
                        negocio.getEstadoNegocio(),negocio.getTipoNegocio(),negocio.getUbicacion(),
                        negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion())).toList();
        return items;
    }

    @Override
    public List<ItemNegocioDTO> filtrarPorNombreYUbicacion(FiltrarNombreUbicacionDTO filtrarPorNombreYUbicacionDTO) {
        List<Negocio> negocios=negocioRepo.findByNombreContainingAndUbicacion(filtrarPorNombreYUbicacionDTO.nombre(),filtrarPorNombreYUbicacionDTO.ubicacion());
        List<ItemNegocioDTO> items=negocios.stream()
                .map(negocio-> new ItemNegocioDTO(negocio.getCodigoNegocio(),
                        negocio.getCodigoCliente(),negocio.getNombre(),negocio.getDescripcion(),
                        negocio.getEstadoNegocio(),negocio.getTipoNegocio(),negocio.getUbicacion(),
                        negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion())).toList();
        return items;
    }

    @Override
    public List<ItemNegocioDTO> filtrarPorNombreYTipoNegocioYUbicacion(FiltrarNombreTipoUbicacionDTO filtrarPorNombreYTipoYUbicacionDTO) {
        List<Negocio> negocios=negocioRepo.findByNombreContainingAndTipoNegocioAndUbicacion(filtrarPorNombreYTipoYUbicacionDTO.nombre(),
                filtrarPorNombreYTipoYUbicacionDTO.tipoNegocio(),filtrarPorNombreYTipoYUbicacionDTO.ubicacion());
        List<ItemNegocioDTO> items=negocios.stream()
                .map(negocio-> new ItemNegocioDTO(negocio.getCodigoNegocio(),
                        negocio.getCodigoCliente(),negocio.getNombre(),negocio.getDescripcion(),
                        negocio.getEstadoNegocio(),negocio.getTipoNegocio(),negocio.getUbicacion(),
                        negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion())).toList();
        return items;
    }

    @Override
    public List<ItemNegocioDTO> listarNegociosPropietario(String codigoCliente) {
        List<Negocio> negocios=negocioRepo.findByCodigoCliente(codigoCliente);
        List<ItemNegocioDTO> items=negocios.stream()
                .map(negocio-> new ItemNegocioDTO(negocio.getCodigoNegocio(),
                        negocio.getCodigoCliente(),negocio.getNombre(),negocio.getDescripcion(),
                        negocio.getEstadoNegocio(),negocio.getTipoNegocio(),negocio.getUbicacion(),
                        negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion())).toList();
        return items;
    }

    @Override
    public List<ItemNegocioDTO> listarMejoresNegocios() {
      List<Negocio> negocios=negocioRepo.findTop5ByBestCalificacion();
      List<ItemNegocioDTO> items=negocios.stream()
              .map(negocio-> new ItemNegocioDTO(negocio.getCodigoNegocio(),
                      negocio.getCodigoCliente(),negocio.getNombre(),negocio.getDescripcion(),
                      negocio.getEstadoNegocio(),negocio.getTipoNegocio(),negocio.getUbicacion(),
                      negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion())).toList();
        return items;

    }

    @Override
    public List<ItemNegocioDTO> listarTop5PorCategoria(TipoNegocio tipoNegocio) {
        List<Negocio> negocios=negocioRepo.findTop5ByBestCalificacion();
        List<ItemNegocioDTO> items=negocios.stream()
                .filter(negocio -> negocio.getTipoNegocio().equals(tipoNegocio))
                .map(negocio-> new ItemNegocioDTO(negocio.getCodigoNegocio(),
                        negocio.getCodigoCliente(),negocio.getNombre(),negocio.getDescripcion(),
                        negocio.getEstadoNegocio(),negocio.getTipoNegocio(),negocio.getUbicacion(),
                        negocio.getTelefonos(),negocio.getHorarios(),negocio.getImagenes(),negocio.getCalificacion())).toList();
        return items;

    }

    public boolean existNombre(String nombre){
        return negocioRepo.findByNombre(nombre).isPresent();
    }

}
