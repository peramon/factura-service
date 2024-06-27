package com.alquimiasoft.invoiceservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    // Customer info
    private String identification;
    private String name;
    private String email;
    private String phone_number;


    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_fk",referencedColumnName = "id")
    private List<Address> addresses;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Invoice> invoices = new HashSet<>();

    // Invoice methods
    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }

   public void removeInvoice(Invoice invoice){
        invoices.remove(invoice);
        invoice.setCustomer(null);
    }
}
