package co.edu.uniquindio.barberiavip.controladores;

import co.edu.uniquindio.barberiavip.modelo.dto.MensajeDTO;
import co.edu.uniquindio.barberiavip.modelo.dto.UsuarioGetDTO;
import co.edu.uniquindio.barberiavip.modelo.dto.UsuarioPostDTO;
import co.edu.uniquindio.barberiavip.servicios.interfaces.UsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    @PutMapping("/{id}")
    public ResponseEntity<MensajeDTO<UsuarioGetDTO>> actualizarUsuario(@PathVariable int id, @RequestBody UsuarioGetDTO usuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO<>(HttpStatus.OK, false,
                usuarioServicio.actualizarUsuario(id, usuario)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensajeDTO<UsuarioGetDTO>> obtenerUsuario(@PathVariable int id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO<>(HttpStatus.OK, false,
                usuarioServicio.obtenerUsuario(id)));
    }

    @GetMapping
    public ResponseEntity<MensajeDTO<List<UsuarioGetDTO>>> listar() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO<>(HttpStatus.OK, false,
                usuarioServicio.listarUsuarios()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeDTO<String>> eliminar(@PathVariable int id) throws Exception {
        usuarioServicio.eliminarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MensajeDTO<>(HttpStatus.NO_CONTENT,
                false, "El usuario con el id " + id + " fue eliminado correctamente"));
    }

}
