package co.edu.uniquindio.proyecto.test;
import co.edu.uniquindio.proyecto.dto.ActualizarClienteDTO;
import co.edu.uniquindio.proyecto.dto.DetalleClienteDTO;
import co.edu.uniquindio.proyecto.dto.RegistroClienteDTO;
import co.edu.uniquindio.proyecto.modelo.Cliente;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.servicios.ClienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ClienteServicioTest {

    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private ClienteServicio clienteServicio;

    @Test
    public void registrarClienteTest() throws Exception {
        RegistroClienteDTO registroClienteDTO = new RegistroClienteDTO(
                "Estocolmo",
                "332545",
                "mi foto",
                "estolcomito",
                "estocolmo@email.com",
                "mipassword",
                "Armenia"
        );
        String codigo=clienteServicio.registrarCliente(registroClienteDTO);
        Assertions.assertNotNull(codigo);

        Optional<Cliente> optionalCliente=clienteRepo.findById(codigo);
        Assertions.assertTrue(optionalCliente.isPresent(), "Cliente no encontrado con código: " + codigo);

        Cliente cliente=optionalCliente.get();
        Assertions.assertEquals("Juan",cliente.getNombre());
        Assertions.assertEquals("mi foto",cliente.getFotoPerfil());
        Assertions.assertEquals("juan@email.com",cliente.getEmail());
        Assertions.assertEquals("mipassword",cliente.getPassword());
        Assertions.assertEquals("Armenia",cliente.getCiudadResidencia());
    }
    @Test
    public void actualizarClienteTest() throws Exception {
        ActualizarClienteDTO actualizarClienteDTO=new ActualizarClienteDTO("Cliente1",
                "Juancho",
                "nueva Foto",
                "nuevaCiudad","nuevo@gmail.com");

        clienteServicio.actualizarCliente(actualizarClienteDTO);

        DetalleClienteDTO cliente=clienteServicio.obtenerCliente("Cliente1");
        Assertions.assertEquals("Juancho",cliente.nombre());

    }

    @Test
    public void listarClienteTest() {
        //Obtenemos la lista de todos los clientes (por ahora solo tenemos 1)
        List<Cliente> clientes = clienteRepo.findAll();
        //Imprimimos los clientes, se hace uso de una función lambda
        clientes.forEach(System.out::println);
        //Verificamos que solo exista un cliente
        Assertions.assertEquals(1, clientes.size());
    }
    @Test
    public void eliminarTest() throws Exception{
        //Se elimina el cliente con el id "Cliente1"
        clienteServicio.eliminarCliente("Cliente1");
        //Al intentar obtener el cliente con el id "Cliente1" se debe lanzar una excepción
        Assertions.assertThrows(Exception.class, () -> clienteServicio.obtenerCliente("Cliente1") );
    }

}