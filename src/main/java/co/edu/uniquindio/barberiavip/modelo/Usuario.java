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
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @OneToMany(mappedBy = "usuario")
    private List<Agenda> agendas;

    @OneToMany(mappedBy = "cliente")
    private List<SolicitudCita> citas_cliente;

    @OneToMany(mappedBy = "barbero")
    private List<SolicitudCita> citas_barbero;

    @OneToMany(mappedBy = "usuario")
    private List<Inscripcion> inscripciones;

    @OneToMany(mappedBy = "cliente")
    private List<Pago> clientes;

}
