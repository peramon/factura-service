package com.alquimiasoft.invoiceservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String formattedDate;

    // Relations
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;*/

    @PrePersist
    public void prePersist(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.formattedDate = LocalDateTime.now().format(formatter);
    }



}
