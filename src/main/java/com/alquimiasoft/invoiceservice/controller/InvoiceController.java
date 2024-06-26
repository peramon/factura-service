package com.alquimiasoft.invoiceservice.controller;

import com.alquimiasoft.invoiceservice.entity.Invoice;
import com.alquimiasoft.invoiceservice.service.CustomerService;
import com.alquimiasoft.invoiceservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public List<Invoice> getInvoices() { return invoiceService.getAllInvoices();}


}
