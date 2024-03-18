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
public class MetodoPago {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_metodo;

    @NotBlank
    private String numero_tarjeta;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fecha_expiracion;

    @NotNull
    private String primer_nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String ciudad;
    @NotNull
    private String domicilio_cobro;
    @NotNull
    private String telefono;

    @OneToMany(mappedBy = "metodo_pago")
    @ToString.Exclude
    private List<Pago> pagos;

    @NotNull
    private boolean activo;

}
