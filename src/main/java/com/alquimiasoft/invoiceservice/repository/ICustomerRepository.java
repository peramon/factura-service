package com.alquimiasoft.invoiceservice.repository;

import com.alquimiasoft.invoiceservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
    @Query(value = "SELECT c.name , d.address \n" +
            "FROM CUSTOMER c, ADDRESS d\n" +
            "WHERE c.id = :id\n" +
            "AND c.id = d.cd_fk", nativeQuery = true)
    public List<Map<String, String>> getInformation(Integer id);

    @Query(value="SELECT * FROM CUSTOMER WHERE CUSTOMER.IDENTIFICATION = :identification", nativeQuery = true)
    public Customer searchByIdentification(String identification);
}
