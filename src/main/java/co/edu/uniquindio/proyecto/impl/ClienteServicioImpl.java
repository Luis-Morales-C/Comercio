package co.edu.uniquindio.proyecto.impl;

import co.edu.uniquindio.proyecto.dto.DetalleClienteDTO;
import co.edu.uniquindio.proyecto.dto.RegistroClienteDTO;
import co.edu.uniquindio.proyecto.modelo.Cliente;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.servicios.ClienteServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteServicioImpl implements ClienteServicio {

    private final ClienteRepo clienteRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo){
        this.clienteRepo=clienteRepo;
    }
    @Override
    public String registrarCliente(RegistroClienteDTO registroClienteDTO) throws Exception {


        if( existeEmail(registroClienteDTO.email()) ){
            throw new Exception("El correo ya se encuentra registrado");
        }

        if( existeNickname(registroClienteDTO.nickname()) ){
            throw new Exception("El nickname ya se encuentra registrado por otro usuario");
        }


        Cliente cliente = Cliente.builder()
                .nombre(registroClienteDTO.nombre())
                .fotoPerfil(registroClienteDTO.fotoPerfil())
                .email(registroClienteDTO.email())
                .password(registroClienteDTO.password())
                .ciudadResidencia(registroClienteDTO.ciudadResidencia())
                .build();

        Cliente clienteGuardado = clienteRepo.save(cliente);

        return clienteGuardado.getCodigo();
    }

    @Override
    public void actualizarCliente() throws Exception {

    }

    @Override
    public Cliente obtenerCliente(DetalleClienteDTO detalleClienteDTO) throws Exception {
        return null;
    }

    @Override
    public void eliminarCliente() throws Exception {

    }

    @Override
    public List<Cliente> listarCliente() throws Exception {
        return List.of();
    }

    private boolean existeEmail(String email) {
        return clienteRepo.findByEmail(email).isPresent();
    }
    private boolean existeNickname(String nickname) {
        return clienteRepo.findByEmail(nickname).isPresent();
    }

}
