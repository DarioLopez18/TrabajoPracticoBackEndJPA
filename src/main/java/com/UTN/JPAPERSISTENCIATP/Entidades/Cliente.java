package com.UTN.JPAPERSISTENCIATP.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends BaseEntidad{
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name="idCliente")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente-id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarDomicilio(Domicilio domicilio){
        domicilios.add(domicilio);
    }
    public void agregarPedido(Pedido ped){

        pedidos.add(ped);
    }

    public void mostrarDomicilios(){
        System.out.println("Domicilios de: " + nombre + " " + apellido);
        for(Domicilio domicilio:domicilios){
            System.out.println("Calle: "+ domicilio.getCalle() + "Numero: " + domicilio.getNumero() + "Localidad: " + domicilio.getLocalidad());
        }
    }

}
