package co.edu.uniquindio.barberiavip.servicios.implementacion;

import co.edu.uniquindio.barberiavip.modelo.dto.SesionDTO;
import co.edu.uniquindio.barberiavip.modelo.dto.TokenDTO;
import co.edu.uniquindio.barberiavip.seguridad.modelo.UserDetailsImpl;
import co.edu.uniquindio.barberiavip.seguridad.servicios.JwtService;
import co.edu.uniquindio.barberiavip.servicios.interfaces.SesionServicio;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SesionServicioImpl implements SesionServicio {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public TokenDTO login(SesionDTO sesionDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        sesionDTO.getEmail(),
                        sesionDTO.getPassword())

        );
        UserDetails user = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);
        return new TokenDTO(jwtToken);
    }

    @Override
    public void logout(String id_usuario) {

    }
}
