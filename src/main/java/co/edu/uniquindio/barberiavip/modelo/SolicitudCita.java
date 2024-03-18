package co.edu.uniquindio.barberiavip.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SolicitudCita {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_solicitud;

    @NotNull
    private double precio;

    @NotNull
    private Date fecha;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Estado estado;

    @ManyToOne(optional = false)
    private Usuario cliente;

    @ManyToOne(optional = false)
    private Usuario barbero;

    @ManyToMany(mappedBy = "citas")
    @ToString.Exclude
    private List<Servicio> servicios;

    @OneToOne(mappedBy = "solicitud_cita")
    private Pago pago;

    @NotNull
    private boolean activo;

}
