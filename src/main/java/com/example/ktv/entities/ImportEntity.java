package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "tbImport")
public class ImportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
    private LocalDateTime dateImport;
    private  Double amount;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;

    @OneToMany(mappedBy = "importProduct",cascade = CascadeType.ALL)
    private List<ImportDetailEntity> importDetail;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;
}
