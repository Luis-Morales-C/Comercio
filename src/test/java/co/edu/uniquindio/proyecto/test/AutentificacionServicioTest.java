package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.LoginDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.AutenticacionServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AutentificacionServicioTest {

    @Autowired
    private AutenticacionServicio auntentificacionServicio;

    @Test
    public void iniciarSesionCliente(){
        LoginDTO loginDTO=new LoginDTO("luis@email.com","mipassword");
        Assertions.assertDoesNotThrow(()->auntentificacionServicio.iniciarSesionCliente(loginDTO));
    }
}
