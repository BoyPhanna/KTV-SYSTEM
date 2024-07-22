package com.example.ktv.exceptions;

public class RoomException extends  BaseException{

    public RoomException(String code) {
        super("room."+code);
    }
    // Check null
    public static RoomException typeNull(){
        return new RoomException("type.null");
    }
    public static RoomException pricePHNull(){
        return new RoomException("pricePH.null");
    }
    public static RoomException statusNull(){
        return new RoomException("status.null");
    }

    //Not found
    public static RoomException roomNotFound(){
        return new RoomException("room.not.found");
    }
    public static RoomException pricePHIncorrect(){
        return new RoomException("pricePH.incorrect");
    }

}
