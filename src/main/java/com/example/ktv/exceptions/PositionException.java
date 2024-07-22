package com.example.ktv.exceptions;

public class PositionException extends  BaseException{

    public PositionException(String code) {
        super("position."+code);
    }

    //Check null
    public static PositionException nameIsNull(){
        return new PositionException("name.null");
    }

    //Not found
    public static PositionException positionNotFound(){
        return  new PositionException("not.found");
    }
    public static PositionException nameIsEmpty(){return  new PositionException("name.empty");}
    public static PositionException haveStaffs(){return  new PositionException("have.staffs");}
}
