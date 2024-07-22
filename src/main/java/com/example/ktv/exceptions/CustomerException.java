package com.example.ktv.exceptions;

public class CustomerException extends  BaseException{
    public CustomerException(String code) {
        super("customer."+code);
    }
    //Check authorize
    public  static  CustomerException  unauthorized(){
        return  new CustomerException ("unauthorized");
    }

    //Check null
    public static  CustomerException  nameIsNull(){
        return  new CustomerException ("name.null");
    }
    public static  CustomerException  phoneIsNull(){
        return  new CustomerException ("phone.null");
    }
    public static  CustomerException  addressIsNull(){
        return  new CustomerException ("address.null");
    }
    public static  CustomerException  genderIsNull(){
        return  new CustomerException ("gender.null");
    }
    public static  CustomerException  dobIsNull(){
        return  new CustomerException ("dob.null");
    }
    public static  CustomerException  salaryIsNull(){
        return  new CustomerException ("salary.null");
    }
    public static  CustomerException  positionIsNull(){
        return  new CustomerException ("position.null");
    }
    public static  CustomerException  passwordIsNull(){
        return  new CustomerException ("password.null");
    }
    // Not found
    public static  CustomerException  staffNotFound(){
        return  new CustomerException ("not.found");
    }
}
