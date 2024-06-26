package com.alquimiasoft.invoiceservice.repository;

import com.alquimiasoft.invoiceservice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {
}
