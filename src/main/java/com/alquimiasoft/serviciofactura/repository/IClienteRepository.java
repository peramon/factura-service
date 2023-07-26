package com.alquimiasoft.serviciofactura.repository;

import com.alquimiasoft.serviciofactura.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
