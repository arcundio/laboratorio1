package co.edu.uniquindio.barberiavip.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private Date fecha_inscripcion;

    @NotNull
    private double precio;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne(optional = false)
    private Curso curso;

    @ManyToOne(optional = false)
    private Usuario usuario;

    @OneToOne(mappedBy = "inscripcion")
    private Pago pago;

    @NotNull
    private boolean activo;

}
