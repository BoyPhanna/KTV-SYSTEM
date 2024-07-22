package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "tbSupplier")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
    private  String name;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<ImportEntity> imports=new ArrayList<>();


}
