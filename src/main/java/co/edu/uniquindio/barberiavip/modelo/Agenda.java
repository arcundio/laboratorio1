package co.edu.uniquindio.barberiavip.modelo;

import jakarta.persistence.*;
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
    private LocalTime hora_entrada;
    private LocalTime hora_salida;
    @ManyToOne
    private Usuario usuario;


}
