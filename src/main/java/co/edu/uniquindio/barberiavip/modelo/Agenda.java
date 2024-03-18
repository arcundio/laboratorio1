package co.edu.uniquindio.barberiavip.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Agenda {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_agenda;

    @Enumerated(EnumType.STRING)
    private DiaSemana dia;

    @NotNull
    private LocalTime hora_entrada;
    @NotNull
    private LocalTime hora_salida;

    @ManyToOne(optional = false)
    private Usuario usuario;

    @NotNull
    private boolean activo;


}
