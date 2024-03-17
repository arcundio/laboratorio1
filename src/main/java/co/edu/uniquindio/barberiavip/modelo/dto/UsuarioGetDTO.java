package co.edu.uniquindio.barberiavip.modelo.dto;

import co.edu.uniquindio.barberiavip.modelo.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioGetDTO {

    private boolean activo;
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    private Rol rol;
}
