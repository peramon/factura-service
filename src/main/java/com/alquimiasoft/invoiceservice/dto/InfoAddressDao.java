package com.alquimiasoft.invoiceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class InfoAddressDao {
    private String name;
    private String address;
}
