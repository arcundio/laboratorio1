package co.edu.uniquindio.barberiavip.test;

import co.edu.uniquindio.barberiavip.modelo.Rol;
import co.edu.uniquindio.barberiavip.modelo.dto.UsuarioGetDTO;
import co.edu.uniquindio.barberiavip.modelo.dto.UsuarioPostDTO;
import co.edu.uniquindio.barberiavip.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registrar() throws Exception {
        UsuarioPostDTO usuarioPostDTO = new UsuarioPostDTO("Juan", "Perez", "32165287887", "julian@mail.com", "ay12", Rol.CLIENTE);
        int nuevo = usuarioServicio.registrarUsuario(usuarioPostDTO);
        System.out.println("id " + nuevo);
        Assertions.assertNotEquals(0, nuevo);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() throws Exception {
        UsuarioGetDTO usuario = usuarioServicio.obtenerUsuario(10);

        usuario.setApellido("Perez");

        UsuarioGetDTO respuesta = usuarioServicio.actualizarUsuario(10, usuario);

        Assertions.assertEquals("Perez", respuesta.getApellido());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() throws Exception {
        UsuarioGetDTO usuario = usuarioServicio.obtenerUsuario(10);

        Assertions.assertEquals("pablo", usuario.getNombre());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() throws Exception {
        usuarioServicio.eliminarUsuario(10);

        UsuarioGetDTO usuario = usuarioServicio.obtenerUsuario(10);

        Assertions.assertFalse(usuario.isActivo());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<UsuarioGetDTO> lista = usuarioServicio.listarUsuarios();

        Assertions.assertFalse(lista.isEmpty());

    }

}
