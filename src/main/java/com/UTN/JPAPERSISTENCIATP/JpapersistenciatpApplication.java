package com.UTN.JPAPERSISTENCIATP;

import com.UTN.JPAPERSISTENCIATP.Entidades.*;
import com.UTN.JPAPERSISTENCIATP.Enumeraciones.EstadoPedido;
import com.UTN.JPAPERSISTENCIATP.Enumeraciones.TipoEnvio;
import com.UTN.JPAPERSISTENCIATP.Enumeraciones.TipoProducto;
import com.UTN.JPAPERSISTENCIATP.Repositorios.ClienteRepository;
import com.UTN.JPAPERSISTENCIATP.Repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class JpapersistenciatpApplication {

	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpapersistenciatpApplication.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean
	CommandLineRunner init(RubroRepository rubroRepository1, ClienteRepository clienteRepository1){
		return args -> {
			System.out.println("----------------ESTOY----FUNCIONANDO---------------------");
			Rubro rubro1 = Rubro.builder()
					.denominacion("Hamburguesa")
					.build();
			Productos producto1 = Productos.builder()
					.tiempoEstimadoCocina(60)
					.denominacion("Hamburguesa con papas")
					.precioVenta(2500)
					.precioCompra(1200)
					.stockActual(50)
					.stockMinimo(3)
					.unidadMedida("lorem")
					.receta("lorem")
					.tipo(TipoProducto.MANUFACTURADO)
					.build();
			Productos producto2 = Productos.builder()
					.tiempoEstimadoCocina(60)
					.denominacion("Hamburguesa doble tasty")
					.precioVenta(3500)
					.precioCompra(1500)
					.stockActual(32)
					.stockMinimo(4)
					.unidadMedida("unidad2")
					.receta("receta2")
					.tipo(TipoProducto.MANUFACTURADO)
					.build();
			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);
			rubroRepository.save(rubro1);
			Cliente cliente1 = Cliente.builder()
					.nombre("Dario")
					.apellido("Lopez")
					.telefono("2616150281")
					.build();
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Roque Saenz Peña")
					.numero("1557")
					.localidad("Godoy Cruz")
					.build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Rodriguez")
					.numero("1234")
					.localidad("Ciudad")
					.build();
			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaString = "2023-09-16";
			// Parsear la cadena en un objeto Date
			Date fecha = formatoFecha.parse(fechaString);
			//Crear Instancia Pedido
			Pedido pedido1 = Pedido.builder()
					.fecha(fecha)
					.total(6200)
					.estado(EstadoPedido.LISTO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.build();
			Pedido pedido2 = Pedido.builder()
					.fecha(fecha)
					.total(6000)
					.estado(EstadoPedido.PREPARACION)
					.tipoEnvio(TipoEnvio.RETIRA)
					.build();
			Factura factura1 = Factura.builder()
					.fecha(fecha)
					.numero(1)
					.descuento(0)
					.build();
			Factura factura2 = Factura.builder()
					.fecha(fecha)
					.numero(2)
					.descuento(0)
					.build();
			cliente1.agregarPedido(pedido1);
			cliente1.agregarPedido(pedido2);
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);

			clienteRepository.save(cliente1);
			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			}
		};
	}

}
