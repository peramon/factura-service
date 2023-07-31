package com.alquimiasoft.serviciofactura.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    // Datos del cliente
    private String tipoIdentificacion;
    private String identificacion;
    private String nombre;
    private String correo;
    private String numeroCelular;

    @OneToMany(targetEntity = Direccion.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_fk",referencedColumnName = "id")
    private List<Direccion> direcciones;

}
