package com.UTN.JPAPERSISTENCIATP.Entidades;

import com.UTN.JPAPERSISTENCIATP.Enumeraciones.EstadoPedido;
import com.UTN.JPAPERSISTENCIATP.Enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad{
    private EstadoPedido estado;
    private Date fecha;

    private TipoEnvio tipoEnvio;
    private double total;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "idFactura")
    private Factura factura;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name="detalle-pedido",
            joinColumns = @JoinColumn(name="pedido-id"),
            inverseJoinColumns = @JoinColumn(name="producto_id")
    )
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Productos> productos = new HashSet<>();


}
