package com.alquimiasoft.invoiceservice.repository;

import com.alquimiasoft.invoiceservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Integer> {
}
