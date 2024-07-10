package co.edu.uniquindio.proyecto.servicios.impl;

import co.edu.uniquindio.proyecto.dto.DetalleNegocioDTO;
import co.edu.uniquindio.proyecto.modelo.Negocio;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.NegocioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ModeradorServicioImpl implements ModeradorServicio {

    private final NegocioRepo negocioRepo;

    public ModeradorServicioImpl(ModeradorRepo moderadorRepo, NegocioRepo negocioRepo) {
        this.negocioRepo = negocioRepo;
    }


    @Override
    public void aprobarNegocio(DetalleNegocioDTO detalleNegocioDTO) throws Exception {
        //If inicio sesion
        Optional<Negocio> negocioOptional=negocioRepo.findById(detalleNegocioDTO.codigoNegocio());
        if(negocioOptional.isPresent()){
            throw new Exception("El negocio no existe");
        }
        Negocio negocioActual = negocioOptional.get();
        negocioActual.setEstadoNegocio(detalleNegocioDTO.estadoNegocio());
        negocioRepo.save(negocioActual);
    }

    @Override
    public void revisarNegocio(Negocio negocio) {

    }
}
