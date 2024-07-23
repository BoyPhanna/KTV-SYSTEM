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

    public  static CustomerException nameIsEmpty(){
        return  new CustomerException("name.empty");
    }
    public  static CustomerException phoneIsEmpty(){
        return  new CustomerException("phone.empty");
    }
    public  static CustomerException addressIsEmpty(){
        return  new CustomerException("address.empty");
    }
    public  static CustomerException emailIncorrect(){
        return  new CustomerException("email.incorrect");
    }
    public  static CustomerException passwordNotSecurity(){
        return  new CustomerException("password.not-security");
    }
    public  static CustomerException passwordNotMatch(){
        return  new CustomerException("password.not-match");
    }
    public  static CustomerException nameIncorrect(){
        return  new CustomerException("name.incorrect");
    } public  static CustomerException phoneIncorrect(){
        return  new CustomerException("phone.incorrect");
    }
    public  static CustomerException genderIncorrect(){
        return   new CustomerException("gender.incorrect");
    }
    public static CustomerException loginFailed(){
        return new CustomerException("login.failed-password-or-email-incorrect");
    }
    public static CustomerException emailIsExists(){
        return new CustomerException("email.exists");
    }
    public static CustomerException accountNotVerify(){
        return new CustomerException("account.not-verify");
    }
    public static CustomerException verifyCodeIsNull(){
        return new CustomerException("verify-code.is-null");
    }   public static CustomerException verifyFailed(){
        return new CustomerException("verify.failed");
    }


}
