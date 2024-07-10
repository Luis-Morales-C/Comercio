package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ActualizarClienteDTO;
import co.edu.uniquindio.proyecto.dto.DetalleClienteDTO;
import co.edu.uniquindio.proyecto.dto.ItemClienteDTO;
import co.edu.uniquindio.proyecto.dto.RegistroClienteDTO;

import java.util.List;

public interface ClienteServicio {
    String registrarCliente(RegistroClienteDTO registroClienteDTO)throws Exception;
    void actualizarCliente(ActualizarClienteDTO actualizarClienteDTO)throws Exception;
    DetalleClienteDTO obtenerCliente(String id)throws Exception;
    void eliminarCliente(String id)throws Exception;
    List<ItemClienteDTO> listarClientes()throws Exception;
}
