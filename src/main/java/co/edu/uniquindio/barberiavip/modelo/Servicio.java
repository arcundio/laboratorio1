package co.edu.uniquindio.barberiavip.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Servicio {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_servicio;

    @NotNull
    private String descripcion;

    @NotNull
    private double precio;

    @ManyToMany
    @ToString.Exclude
    private List<SolicitudCita> citas;

    @NotNull
    private boolean activo;

}
