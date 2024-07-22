package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "tbCheckOut")
public class CheckOutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
    private LocalDateTime dateCheckout;

    @OneToOne
    @JoinColumn(name = "checkIn_id")
    private CheckInEntity checkIn;
    private  Double totalAmount;

    @OneToOne(mappedBy = "checkOut")
    private InvoiceEntity invoice;

}
