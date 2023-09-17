package com.UTN.JPAPERSISTENCIATP.Entidades;

import com.UTN.JPAPERSISTENCIATP.Enumeraciones.TipoProducto;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Productos extends  BaseEntidad{

    private TipoProducto tipo;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String receta;

    @ManyToMany(mappedBy = "productos")
    private Set<Pedido> pedidos = new HashSet<>();

}
