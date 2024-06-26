package com.alquimiasoft.invoiceservice.service;

import com.alquimiasoft.invoiceservice.entity.Invoice;
import com.alquimiasoft.invoiceservice.repository.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    IInvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() { return invoiceRepository.findAll();}
    public Invoice saveInvoice(Invoice newInvoice) { return invoiceRepository.save(newInvoice);}
}
