package com.alquimiasoft.serviciofactura.repository;

import com.alquimiasoft.serviciofactura.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDireccionRepository extends JpaRepository<Direccion, Integer> {
}
