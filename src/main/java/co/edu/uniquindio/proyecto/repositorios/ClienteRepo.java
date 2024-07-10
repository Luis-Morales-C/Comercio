package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Cliente;
import co.edu.uniquindio.proyecto.modelo.EstadoRegistro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepo extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByNickname(String nickname);
    Optional<Cliente> findByCedula(String cedula);
    Optional<Cliente> findById(String id);


}