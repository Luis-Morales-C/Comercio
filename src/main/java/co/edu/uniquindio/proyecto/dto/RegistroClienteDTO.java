package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

public record RegistroClienteDTO (

        @NotBlank @Length(max=50) String nombre,
        @NotBlank @Id @Length(max=50) String cedula,
        @NotBlank String fotoPerfil,
        @NotBlank @Length(max=50) String nickname,
        @NotBlank @Email String email,
        @NotBlank @Length(min=4,max=30) String password,
        @NotBlank @Length(max=50) String ciudadResidencia
) {
}