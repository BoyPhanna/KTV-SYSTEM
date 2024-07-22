package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "tbProduct")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
    private String name;
    private Double pricePU;
    private Integer qty;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ImportDetailEntity> importDetail;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<InvoiceDetailEntity> invoiceDetails=new ArrayList<>();
}
