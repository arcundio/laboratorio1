package co.edu.uniquindio.barberiavip.modelo;

import jakarta.annotation.Nullable;
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
public class Pago {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pago;

    @NotNull
    private double monto;

    @NotNull
    private Date fecha_pago;

    @ManyToOne(optional = false)
    private MetodoPago metodo_pago;

    @ManyToOne(optional = false)
    private Usuario cliente;

    @OneToOne
    private Inscripcion inscripcion;

    @OneToOne
    private SolicitudCita solicitud_cita;

    @NotNull
    private boolean activo;

}
