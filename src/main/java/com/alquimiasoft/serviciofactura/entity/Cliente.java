package com.alquimiasoft.serviciofactura.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    // Datos del cliente
    private String tipoIdentificacion;
    private String identificacion;
    private String nombre;
    private String correo;
    private String numeroCelular;
    private String direccion;

}
