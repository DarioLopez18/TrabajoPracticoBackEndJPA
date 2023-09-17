package com.UTN.JPAPERSISTENCIATP.Repositorios;

import com.UTN.JPAPERSISTENCIATP.Entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository<Rubro,Long> {
}
