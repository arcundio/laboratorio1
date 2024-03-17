package co.edu.uniquindio.barberiavip.seguridad.servicios;

import co.edu.uniquindio.barberiavip.modelo.Usuario;
import co.edu.uniquindio.barberiavip.repositorios.UsuarioRepo;
import co.edu.uniquindio.barberiavip.seguridad.modelo.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepo.findByEmail(email);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("El usuario no existe");
        } else {
            return UserDetailsImpl.build(usuario.get());
        }
    }
}
