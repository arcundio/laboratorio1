package co.edu.uniquindio.barberiavip.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
public class Curso {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_curso;

    @NotNull
    private double precio;

    @NotNull
    private String nombre_curso;

    @NotNull
    private String descripcion;

    @NotNull
    private Date fecha_inicio;

    @NotNull
    private Date fecha_fin;

    @OneToMany(mappedBy = "curso")
    @ToString.Exclude
    private List<Inscripcion> inscripciones;

    @NotNull
    private boolean activo;

}
