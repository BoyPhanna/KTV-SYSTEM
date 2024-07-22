package com.example.ktv.exceptions;

public class BookingException extends BaseException{
    public BookingException(String code) {
        super("booking"+code);
    }
    //Check null
    public static BookingException customerIsNull(){
        return new BookingException("customer.null");
    }
    public static BookingException roomIsNull(){
        return new BookingException("room.null");
    }
    public static BookingException dateBookingIsNull(){
        return new BookingException("dateBooking.null");
    }
    public static BookingException timeIsNull(){
        return new BookingException("time.null");
    }
    public static BookingException bookingIsNull(){
        return new BookingException("bookingAmount.null");
    }

    public static BookingException bookingAmountIncorrect(){
        return new BookingException("bookingAmount.incorrect");
    }
}
