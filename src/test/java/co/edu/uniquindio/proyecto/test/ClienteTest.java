package co.edu.uniquindio.proyecto.test;
import co.edu.uniquindio.proyecto.modelo.Cliente;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrarClienteTest(){
    //Creamos el cliente con sus propiedades
        Cliente cliente = Cliente.builder()
                .cedula("1213444")
                .nombre("Pepito perez")
                .email("pepito@email.com")
                .telefono( List.of("12121", "232323") ).build();
    //Guardamos el cliente
        Cliente registro = clienteRepo.save( cliente );
    //Verificamos que se haya guardado validando que no sea null
        Assertions.assertNotNull(registro);
    }
}