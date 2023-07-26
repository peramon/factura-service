package com.alquimiasoft.serviciofactura.repository;

import com.alquimiasoft.serviciofactura.dto.InfoDireccionDao;
import com.alquimiasoft.serviciofactura.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface IClienteRepository extends JpaRepository<Cliente, Integer>{
    @Query(value = "SELECT c.nombre , d.direccion \n" +
            "FROM CLIENTE c, DIRECCION d\n" +
            "WHERE c.id = :id\n" +
            "AND c.id = d.cd_fk", nativeQuery = true)
    public List<Map<String, String>> getInformation(Integer id);
}
