package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ActualizarNegocioDTO;
import co.edu.uniquindio.proyecto.dto.CrearNegocioDTO;
import co.edu.uniquindio.proyecto.dto.ItemNegocioDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.modelo.EstadoNegocio;
import co.edu.uniquindio.proyecto.modelo.Ubicacion;
import co.edu.uniquindio.proyecto.servicios.interfaces.NegocioServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/negocios")
public class NegocioControlador {
    private final NegocioServicio negocioServicio;

    @PostMapping("/crear-negocio")
    public ResponseEntity<MensajeDTO<String>> crearNegocio(@Valid @RequestBody CrearNegocioDTO crearNegocioDTO)throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false,negocioServicio.crearNegocio(crearNegocioDTO)));
    }
    @DeleteMapping("/eliminar-negocio/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarNegocio(@PathVariable String codigo)throws Exception{
        negocioServicio.eliminarNegocio(codigo);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,"Negocio eliminado exitosamente"));
    }
    @PutMapping("/actualizar-negocio")
    public ResponseEntity<MensajeDTO<String>> actualizarNegocio(@Valid @RequestBody ActualizarNegocioDTO actualizarNegocioDTO)throws Exception{
        negocioServicio.actualizarNegocio(actualizarNegocioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,"Negocio actualizado exitosamente"));
    }
    @GetMapping("/obtener-negocio-codigo/{codigo}")
    public ResponseEntity<MensajeDTO<ItemNegocioDTO>> obtenerNegocioCodigo(@PathVariable String codigo)throws Exception{
        negocioServicio.obtenerNegocioPorCodigo(codigo);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,negocioServicio.obtenerNegocioPorCodigo(codigo)));
    }
    @GetMapping("/obtener-negocio-nombre/{nombre}")
    public ResponseEntity<MensajeDTO<ItemNegocioDTO>> obtenerNegocioNombre(@PathVariable String nombre)throws Exception{
        negocioServicio.obtenerNegocioPorNombre(nombre);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,negocioServicio.obtenerNegocioPorNombre(nombre)));
    }
    @GetMapping("/filtrar-estado")
    public ResponseEntity<MensajeDTO<List<ItemNegocioDTO>>> filtrarPorEstado(EstadoNegocio estadoNegocio)throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false,negocioServicio.filtrarPorEstado(estadoNegocio)));
    }
    @GetMapping("/filtrar-ubicacion")
    public ResponseEntity<MensajeDTO<List<ItemNegocioDTO>>> filtrarPorUbicacion(Ubicacion ubicacion)throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false,negocioServicio.filtrarPorUbicacion(ubicacion)));
    }

}
