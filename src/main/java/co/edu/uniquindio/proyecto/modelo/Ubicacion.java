package co.edu.uniquindio.proyecto.modelo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Getter
@Setter
@ToString

public class Ubicacion {
    @NotBlank double longitud;
    @NotBlank double latitud;
}
