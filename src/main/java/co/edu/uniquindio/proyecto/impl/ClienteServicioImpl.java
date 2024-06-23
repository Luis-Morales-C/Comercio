package co.edu.uniquindio.proyecto.impl;

import co.edu.uniquindio.proyecto.dto.ActualizarClienteDTO;
import co.edu.uniquindio.proyecto.dto.DetalleClienteDTO;
import co.edu.uniquindio.proyecto.dto.ItemClienteDTO;
import co.edu.uniquindio.proyecto.dto.RegistroClienteDTO;
import co.edu.uniquindio.proyecto.exception.ResourceNotFoundException;
import co.edu.uniquindio.proyecto.modelo.Cliente;
import co.edu.uniquindio.proyecto.modelo.EstadoRegistro;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.servicios.ClienteServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                .cedula(registroClienteDTO.cedula())
                .nombre(registroClienteDTO.nombre())
                .nickname(registroClienteDTO.nickname())
                .fotoPerfil(registroClienteDTO.fotoPerfil())
                .email(registroClienteDTO.email())
                .password(registroClienteDTO.password())
                .ciudadResidencia(registroClienteDTO.ciudadResidencia())
                .build();

        Cliente clienteGuardado = clienteRepo.save(cliente);

        return clienteGuardado.getCodigo();
    }

    @Override
    public void actualizarCliente(ActualizarClienteDTO actualizarClienteDTO) throws Exception {
        Optional<Cliente> optionalCliente = clienteRepo.findById(actualizarClienteDTO.id());

       if(optionalCliente.isEmpty()){
           throw new ResourceNotFoundException("Cliente no encontrado");
       }
       if(existeEmail(actualizarClienteDTO.email())){
           throw new Exception("El email ya existe");
       }
       Cliente cliente = optionalCliente.get();
       cliente.setNombre(actualizarClienteDTO.nombre());
       cliente.setFotoPerfil(actualizarClienteDTO.fotoPerfil());
       cliente.setEmail(actualizarClienteDTO.email());
       cliente.setCiudadResidencia(actualizarClienteDTO.ciudadResidencia());

       clienteRepo.save(cliente);
    }

    @Override
    public DetalleClienteDTO obtenerCliente(String id) throws Exception {
       Optional<Cliente> optionalCliente = clienteRepo.findById(id);
       if(optionalCliente.isEmpty()){
           throw new ResourceNotFoundException("No se pudo encontrar el id del cliente ,"+id);
       }
       Cliente cliente=optionalCliente.get();

       return new DetalleClienteDTO(cliente.getCodigo(),cliente.getNombre(),cliente.getFotoPerfil(),
       cliente.getNickname(),cliente.getEmail(),cliente.getCiudadResidencia());
    }


    @Override
    public void eliminarCliente(String id) throws Exception {
        Optional<Cliente> optionalCliente=clienteRepo.findById(id);
        if(optionalCliente.isEmpty()){
            throw new ResourceNotFoundException("Cliente no encontrado");
        }
        Cliente cliente=optionalCliente.get();
        cliente.setEstado(EstadoRegistro.INACTIVO);

        clienteRepo.save(cliente);

    }

    @Override
    public List<ItemClienteDTO> listarCliente() throws Exception {
        List<Cliente> clientes=clienteRepo.findAll();

        List<ItemClienteDTO> lista=new ArrayList<>();
        for (Cliente cliente : clientes){
           lista.add(new ItemClienteDTO(cliente.getCodigo(),cliente.getNombre(),cliente.getFotoPerfil(),
                    cliente.getNickname(),cliente.getCiudadResidencia()));
        }
        return lista;

    }

    private boolean existeEmail(String email) {
        return clienteRepo.findByEmail(email).isPresent();
    }
    private boolean existeNickname(String nickname) {
        return clienteRepo.findByNickname(nickname).isPresent();
    }
    private boolean existeCedula(String cedula) {
        return clienteRepo.findByEmail(cedula).isPresent();
    }


}
