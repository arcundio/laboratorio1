package co.edu.uniquindio.barberiavip.controladores;

import co.edu.uniquindio.barberiavip.modelo.dto.MensajeDTO;
import co.edu.uniquindio.barberiavip.modelo.dto.UsuarioPostDTO;
import co.edu.uniquindio.barberiavip.servicios.interfaces.UsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    @PostMapping
    public ResponseEntity<MensajeDTO<String>> registrarUsuario(@Valid @RequestBody UsuarioPostDTO usuario) throws Exception {

        int id_usuario = usuarioServicio.registrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO<String>(HttpStatus.CREATED,
                false, "Cliente creado correctamente con el codigo "+ id_usuario));
    }

}
