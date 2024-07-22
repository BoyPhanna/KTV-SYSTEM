package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "tbInvoiceDetail")
public class InvoiceDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
   @ManyToOne
    @JoinColumn(name = "invoice_id")
   private InvoiceEntity invoice;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    private  Integer qty;
    private Double total;
}
