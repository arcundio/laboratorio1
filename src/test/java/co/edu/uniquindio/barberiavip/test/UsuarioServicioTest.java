package co.edu.uniquindio.barberiavip.test;

import co.edu.uniquindio.barberiavip.modelo.Rol;
import co.edu.uniquindio.barberiavip.modelo.dto.UsuarioPostDTO;
import co.edu.uniquindio.barberiavip.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registrar() throws Exception {
        UsuarioPostDTO usuarioPostDTO = new UsuarioPostDTO("Juan", "Perez", "32165287887",
                "julian@mail.com", "ay12", Rol.CLIENTE);
        int nuevo = usuarioServicio.registrarUsuario(usuarioPostDTO);
        System.out.println("id " +nuevo);
        Assertions.assertNotEquals(0, nuevo);
    }

}
