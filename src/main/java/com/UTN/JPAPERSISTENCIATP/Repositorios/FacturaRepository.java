package com.UTN.JPAPERSISTENCIATP.Repositorios;

import com.UTN.JPAPERSISTENCIATP.Entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
