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
public class Curso {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_curso;

    private double precio;
    private String nombre_curso;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;

    @OneToMany(mappedBy = "curso")
    @ToString.Exclude
    private List<Inscripcion> inscripciones;


}
