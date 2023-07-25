package com.alquimiasoft.serviciofactura.repository;

import com.alquimiasoft.serviciofactura.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICliente extends JpaRepository<Cliente, Long>{

}
