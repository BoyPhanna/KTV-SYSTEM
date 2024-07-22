package com.example.ktv.exceptions;

public class SupplierException extends BaseException{
    public SupplierException(String code) {
        super("Supplier."+code);
    }
    public static SupplierException unauthorized() {
        return new SupplierException("unauthorized");
    }

//    Validated
    public static  SupplierException nameIsNull(){
        return  new SupplierException("name.null");
    }
    public static  SupplierException phoneIsNull(){
        return  new SupplierException("phone.null");
    }
    public static  SupplierException addressIsNull(){
        return  new SupplierException("address.null");
    }

    // Not found
    public static  SupplierException supplierNotFound(){
        return  new SupplierException("supplier.not.found");
    }
    public static  SupplierException nameNotFount(){
        return  new SupplierException("name.not.found");
    }
    public static  SupplierException phoneNotFound(){
        return  new SupplierException("phone.not.found");
    }

    public static  SupplierException addressNotFound(){
        return  new SupplierException("address.not.found");
    }

}
