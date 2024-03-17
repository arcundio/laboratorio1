package co.edu.uniquindio.barberiavip.modelo.dto;

import co.edu.uniquindio.barberiavip.modelo.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioPostDTO {

    @NotBlank
    @Length(max = 100, message = "el nombre debe tener máximo 100 carácteres")
    private String nombre;
    @NotBlank
    @Length(max = 100, message = "el nombre debe tener máximo 100 carácteres")
    private String apellido;
    @NotBlank
    @Length(max = 12, message = "El teléfono debe tener máximo 12 caracteres")
    private String telefono;

    @NotBlank
    @Email
    @Length(max = 100, message = "El correo debe tener máximo 100 caracteres")
    private String email;

    @NotBlank
    @Length(max = 50, message = "La contraseña debe tener máximo 50 caracteres")
    private String password;
    @NotBlank
    private Rol rol;

}
