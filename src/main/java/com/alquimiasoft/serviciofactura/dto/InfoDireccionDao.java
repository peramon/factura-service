package com.alquimiasoft.serviciofactura.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class InfoDireccionDao {
    private String nombre;
    private String direccion;
}
