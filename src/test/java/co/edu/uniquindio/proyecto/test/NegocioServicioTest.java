package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.exception.ResourceNotFoundException;
import co.edu.uniquindio.proyecto.modelo.*;
import co.edu.uniquindio.proyecto.repositorios.NegocioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.NegocioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class NegocioServicioTest {

    @Autowired
    NegocioRepo negocioRepo;

    @Autowired
    NegocioServicio negocioServicio;

    @Test
    public void crearNegocioTest() throws Exception {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setLatitud(12343);
        ubicacion.setLongitud(2442);

        List<String> telefonos = new ArrayList<>();
        telefonos.add("31029423");
        telefonos.add("31348228");

        List<Horario> listaHorarios = new ArrayList<>();
        Horario horario = new Horario();
        horario.setDia("Viernes");
        horario.setHoraInicio(LocalTime.of(12, 30));
        horario.setHoraFin(LocalTime.of(16, 50));
        listaHorarios.add(horario);

        List<String> imagenes = new ArrayList<>();
        imagenes.add("img1");
        imagenes.add("img2");

        CrearNegocioDTO negocio = new CrearNegocioDTO(
                "332545",
                "FIRST",
                "Hi,This my first business",
                TipoNegocio.CAFETERIA,
                ubicacion,
                telefonos,
                listaHorarios,
                imagenes
        );
        String codigo=negocioServicio.crearNegocio(negocio);
        Assertions.assertNotNull(codigo);

        Optional<Negocio> negocioOptional = negocioRepo.findById(codigo);
        Assertions.assertTrue(negocioOptional.isPresent());

        Negocio negocio1=negocioOptional.get();

        //Verificamos que los datos sean los mismos a los guardados
        Assertions.assertEquals("FIRST",negocio1.getNombre());
    }
    @Test
    public void eliminarNegocio() throws Exception{
        String codigo="Cliente1";
        Assertions.assertThrows(ResourceNotFoundException.class,()->negocioServicio.eliminarNegocio(codigo));

        Optional<Negocio> negocioOptional=negocioRepo.findById(codigo);
        Assertions.assertFalse(negocioOptional.isPresent());
    }
    @Test
    public void actualizarNegocio()throws Exception{
        List<String> telefonos = new ArrayList<>(List.of());
        telefonos.add("325281934");
        telefonos.add("313245234");

        List<Horario> listaHorarios = new ArrayList<>();
        Horario horario = new Horario();
        horario.setDia("Viernes");
        horario.setHoraInicio(LocalTime.of(12, 30));
        horario.setHoraFin(LocalTime.of(16, 50));
        listaHorarios.add(horario);

        List<String> imagenes = new ArrayList<>();
        imagenes.add("img1");
        imagenes.add("img2");

        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setLatitud(12343);
        ubicacion.setLongitud(2442);


        ActualizarNegocioDTO actualizarNegocioDTO=new ActualizarNegocioDTO(
                "Negocio1",
                "new name",
                "new description",
                TipoNegocio.BAR,
                ubicacion,
                telefonos,
                listaHorarios,
                imagenes);

        Assertions.assertDoesNotThrow(()->negocioServicio.actualizarNegocio(actualizarNegocioDTO));

    }
    @Test
    public void obtenerNegocioIdTest(){
        String codigo="Negocio1";
        ItemNegocioDTO itemNegocioDTO=negocioServicio.obtenerNegocioPorCodigo(codigo);
        Assertions.assertNotNull(itemNegocioDTO);
        System.out.println(itemNegocioDTO);
    }
    @Test
    public void obtenerNegocioNombreTest(){
        String nombre="new name";
        ItemNegocioDTO itemNegocioDTO=negocioServicio.obtenerNegocioPorNombre(nombre);
        Assertions.assertNotNull(itemNegocioDTO);
        System.out.println(itemNegocioDTO);
    }
    @Test
    public void filtrarPorEstadoTest(){
     List<ItemNegocioDTO> List = negocioServicio.filtrarPorEstado(EstadoNegocio.PENDIENTE);

        Assertions.assertNotNull(List);
        Assertions.assertEquals(2, List.size());
        for(ItemNegocioDTO itemNegocioDTO:List){
            System.out.print(itemNegocioDTO);
        }

    }
    @Test
    public void filtrarPorUbicacionTest(){
        Ubicacion ubicacion=new Ubicacion();
        ubicacion.setLongitud(101010);
        ubicacion.setLatitud(101010);
        List<ItemNegocioDTO> list = negocioServicio.filtrarPorUbicacion(ubicacion);

        Assertions.assertNotNull(list);
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("Negocio7",list.get(0).codigoNegocio());
        for(ItemNegocioDTO itemNegocioDTO:list){
            System.out.print(itemNegocioDTO);
        }
    }
}
