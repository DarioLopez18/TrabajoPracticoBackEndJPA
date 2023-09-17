package com.UTN.JPAPERSISTENCIATP.Repositorios;

import com.UTN.JPAPERSISTENCIATP.Entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
