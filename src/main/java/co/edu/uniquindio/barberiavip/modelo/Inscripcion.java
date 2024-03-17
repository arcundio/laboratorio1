package co.edu.uniquindio.barberiavip.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Inscripcion {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_inscripcion;

    private Date fecha_inscripcion;
    private double precio;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Usuario usuario;

}
