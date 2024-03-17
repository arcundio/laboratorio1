package co.edu.uniquindio.barberiavip.implementacion;


import co.edu.uniquindio.barberiavip.modelo.Usuario;
import co.edu.uniquindio.barberiavip.modelo.dto.UsuarioGetDTO;
import co.edu.uniquindio.barberiavip.modelo.dto.UsuarioPostDTO;
import co.edu.uniquindio.barberiavip.repositorios.UsuarioRepo;
import co.edu.uniquindio.barberiavip.servicios.UsuarioServicio;
import co.edu.uniquindio.barberiavip.servicios.excepciones.AttributeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;


    @Override
    public int registrarUsuario(UsuarioPostDTO u) throws Exception {

        if (!estaDisponible(u.getEmail())) {
            throw new AttributeException("El correo " + u.getEmail() + "ya está en uso");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(u.getNombre());
        usuario.setApellido(u.getApellido());
        usuario.setEmail(u.getEmail());
        usuario.setTelefono(u.getTelefono());
        usuario.setPassword(u.getPassword());
        usuario.setRol(u.getRol());

        return usuarioRepo.save(usuario).getId_usuario();
    }

    public boolean estaDisponible(String email) {
        Optional<Usuario> usuario = usuarioRepo.findByEmail(email);
        return usuario.isEmpty();
    }

    @Override
    public UsuarioGetDTO actualizarUsuario(int id_usuario, UsuarioGetDTO usuarioDTO) throws Exception {
        Optional<Usuario> registro = usuarioRepo.findById(id_usuario);

        if (registro.isEmpty()) {
            throw new Exception("El usuario no existe");
        }

        Usuario guardado = registro.get();

        guardado.setNombre(usuarioDTO.getNombre());
        guardado.setApellido(usuarioDTO.getApellido());
        guardado.setEmail(usuarioDTO.getEmail());
        guardado.setTelefono(usuarioDTO.getTelefono());

        return convertir(usuarioRepo.save(guardado));
    }

    @Override
    public int eliminarUsuario(Usuario u) throws Exception {
        return 0;
    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int id_usuario) throws Exception {
        Optional<Usuario> guardado = usuarioRepo.findById(id_usuario);

        if (guardado.isEmpty()) {
            throw new Exception("El código " + id_usuario + " no está asociado a ningún usuario");
        }

        return convertir(guardado.get());

    }

    @Override
    public List<UsuarioGetDTO> listarUsuarios() {
        return convertirLista(usuarioRepo.findAll());
    }

    private UsuarioGetDTO convertir(Usuario usuario) {
        return new UsuarioGetDTO(
                usuario.getId_usuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getTelefono(),
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getRol()
        );
    }

    private List<UsuarioGetDTO> convertirLista(List<Usuario> lista) {
        List<UsuarioGetDTO> respuesta = new ArrayList<>();

        for (Usuario u : lista) {
            respuesta.add(convertir(u));
        }

        return respuesta;
    }
}
