package co.edu.uniquindio.barberiavip.servicios.interfaces;

import co.edu.uniquindio.barberiavip.modelo.dto.SesionDTO;
import co.edu.uniquindio.barberiavip.modelo.dto.TokenDTO;

public interface SesionServicio {
    TokenDTO login(SesionDTO sesionDTO);

    void logout(String id_usuario);

}
