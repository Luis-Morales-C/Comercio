package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServicioTest {

    @Autowired
    private EmailServicio emailServicio;

    @Test
    public void enviarCorreo() throws Exception {
        EmailDTO emailDTO=new EmailDTO("envio correo de prueba",
                "hola","luisc.moralesc@uqvirtual.edu.co");
        Assertions.assertDoesNotThrow(()->emailServicio.enviarCorreo(emailDTO));

    }
}
