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

    private boolean activo;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Agenda> agendas;
    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private List<SolicitudCita> citas_cliente;
    @OneToMany(mappedBy = "barbero")
    @ToString.Exclude
    private List<SolicitudCita> citas_barbero;
    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Inscripcion> inscripciones;
    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private List<Pago> clientes;

}
