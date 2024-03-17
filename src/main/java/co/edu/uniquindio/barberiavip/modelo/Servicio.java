package co.edu.uniquindio.barberiavip.modelo;

import jakarta.persistence.*;
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

    private String descripcion;

    private double precio;

    @ManyToMany
    @ToString.Exclude
    private List<SolicitudCita> citas;

}
