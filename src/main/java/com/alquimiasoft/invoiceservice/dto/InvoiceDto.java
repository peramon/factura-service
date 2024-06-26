package com.alquimiasoft.invoiceservice.dto;

import com.alquimiasoft.invoiceservice.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InvoiceDto {
    private Customer customer;
}
