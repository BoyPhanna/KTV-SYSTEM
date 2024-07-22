package com.example.ktv.exceptions;

public class StaffException extends BaseException{
    public StaffException(String code) {
        super("staff."+code);
    }
    //Check authorize
    public  static  StaffException unauthorized(){
        return  new StaffException("unauthorized");
    }

    //Check null
    public static  StaffException nameIsNull(){
        return  new StaffException("name.null");
    }
    public static  StaffException phoneIsNull(){
        return  new StaffException("phone.null");
    }
    public static  StaffException addressIsNull(){
        return  new StaffException("address.null");
    }
    public static  StaffException genderIsNull(){
        return  new StaffException("gender.null");
    }
    public static  StaffException dobIsNull(){
        return  new StaffException("dob.null");
    }
    public static  StaffException salaryIsNull(){
        return  new StaffException("salary.null");
    }
    public static  StaffException positionIsNull(){
        return  new StaffException("position.null");
    }
    public static  StaffException passwordIsNull(){
        return  new StaffException("password.null");
    }
    public static  StaffException emailIsNull(){
        return  new StaffException("email.null");
    }
    public static  StaffException passwordIsEmpty(){
        return  new StaffException("password.empty");
    }
    public static  StaffException emailIsEmpty(){
        return  new StaffException("email.empty");
    }
    public static  StaffException emailIncorrect(){
        return  new StaffException("email.incorrect");
    }
    public static StaffException salaryIncorrect(){
        return new StaffException("salary.incorrect");
    }
    public static StaffException nameIncorrect(){
        return new StaffException("name.incorrect");
    }
    public static StaffException phoneIncorrect(){
        return new StaffException("phone.incorrect");
    }
    public static StaffException dobIncorrect(){
        return new StaffException("dob.incorrect");
    }
    public static StaffException genderIncorrect(){
        return new StaffException("gender.incorrect");
    }



    // Not found
    public static  StaffException staffNotFound(){
        return  new StaffException("staff.not.found");
    }

}
