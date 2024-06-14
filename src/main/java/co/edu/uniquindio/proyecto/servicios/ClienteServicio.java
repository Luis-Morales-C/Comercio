package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.DetalleClienteDTO;
import co.edu.uniquindio.proyecto.dto.RegistroClienteDTO;
import co.edu.uniquindio.proyecto.modelo.Cliente;

import java.util.List;

public interface ClienteServicio {
    String registrarCliente(RegistroClienteDTO registroClienteDTO)throws Exception;
    void actualizarCliente()throws Exception;
    Cliente obtenerCliente(DetalleClienteDTO detalleClienteDTO)throws Exception;
    void eliminarCliente()throws Exception;
    List<Cliente> listarCliente()throws Exception;
}
