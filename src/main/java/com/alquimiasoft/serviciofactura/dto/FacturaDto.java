package com.alquimiasoft.serviciofactura.dto;

import com.alquimiasoft.serviciofactura.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FacturaDto {
    private Cliente cliente;
}
