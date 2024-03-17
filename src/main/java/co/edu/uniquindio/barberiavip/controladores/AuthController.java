package co.edu.uniquindio.barberiavip.controladores;

import co.edu.uniquindio.barberiavip.modelo.dto.MensajeDTO;
import co.edu.uniquindio.barberiavip.modelo.dto.SesionDTO;
import co.edu.uniquindio.barberiavip.modelo.dto.UsuarioPostDTO;
import co.edu.uniquindio.barberiavip.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.barberiavip.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioServicio usuarioServicio;
    private final SesionServicio sesionServicio;
    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login(@Valid @RequestBody SesionDTO loginUser) {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                sesionServicio.login(loginUser)) );
    }
    @PostMapping("/registro")
    public ResponseEntity<MensajeDTO> registrarCliente(@Valid @RequestBody UsuarioPostDTO usuario) throws Exception {
        usuarioServicio.registrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,
                false, "Cliente creado correctamente"));
    }
}
