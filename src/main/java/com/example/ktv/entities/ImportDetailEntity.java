package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name = "tbImportDetail")
public class ImportDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private  ProductEntity product;
    private Integer qtyImport;
    private Double pricePUImport;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "import_id")
    private ImportEntity importProduct;
}
