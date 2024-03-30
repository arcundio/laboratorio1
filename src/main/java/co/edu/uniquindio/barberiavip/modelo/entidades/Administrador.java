package co.edu.uniquindio.barberiavip.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador {

    @Id
    @Column(nullable = false, length = 50)
    private String correo;

    @Column(nullable = false)
    @Lob
    private String password;
}
