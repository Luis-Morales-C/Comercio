package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.CrearNegocioDTO;
import co.edu.uniquindio.proyecto.modelo.*;
import co.edu.uniquindio.proyecto.repositorios.NegocioRepo;
import co.edu.uniquindio.proyecto.servicios.NegocioServicio;
import org.bson.codecs.jsr310.LocalTimeCodec;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
                "10923",
                "FIRST",
                "Hi,This my first business",
                TipoNegocio.CAFETERIA,
                ubicacion,
                telefonos,
                listaHorarios,
                imagenes

        );
        negocioServicio.crearNegocio(negocio);
        
    }
}
