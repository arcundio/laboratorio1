package co.edu.uniquindio.barberiavip.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String telefono;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @NotNull
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
