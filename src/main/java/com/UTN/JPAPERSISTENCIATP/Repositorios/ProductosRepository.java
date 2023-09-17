package com.UTN.JPAPERSISTENCIATP.Repositorios;

import com.UTN.JPAPERSISTENCIATP.Entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos,Long> {
}
