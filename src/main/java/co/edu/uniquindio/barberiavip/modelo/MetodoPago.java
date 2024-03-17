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
public class MetodoPago {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_metodo;
    private String numero_tarjeta;
    @Temporal(TemporalType.DATE)
    private Date fecha_expiracion;
    private String primer_nombre;
    private String apellido;
    private String ciudad;
    private String domicilio_cobro;
    private String telefono;

    @OneToMany(mappedBy = "metodo_pago")
    @ToString.Exclude
    private List<Pago> pagos;

}
