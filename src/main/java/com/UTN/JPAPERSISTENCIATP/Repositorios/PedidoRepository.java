package com.UTN.JPAPERSISTENCIATP.Repositorios;

import com.UTN.JPAPERSISTENCIATP.Entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
