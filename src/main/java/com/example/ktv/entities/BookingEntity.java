package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "tbBooking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    private LocalDateTime dateBooking;
    private Integer time;
    private LocalDateTime dateCheckIn;
    private LocalDateTime dateCheckOut;
    private  Double bookingPrice;

}
