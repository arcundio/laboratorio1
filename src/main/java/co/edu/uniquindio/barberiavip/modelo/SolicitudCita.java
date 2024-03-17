package co.edu.uniquindio.barberiavip.modelo;

import jakarta.persistence.*;
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

    private double precio;
    private Date fecha;
    @Enumerated(EnumType.ORDINAL)
    private Estado estado;

    @ManyToOne
    private Usuario cliente;

    @ManyToOne
    private Usuario barbero;

    @ManyToMany(mappedBy = "citas")
    @ToString.Exclude
    private List<Servicio> servicios;


}
