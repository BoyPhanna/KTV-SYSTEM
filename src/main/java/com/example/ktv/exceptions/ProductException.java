package com.example.ktv.exceptions;

public class ProductException extends  BaseException{
    public ProductException(String code) {
        super("product."+code);
    }
    //Check null
    public static ProductException nameIsNull(){
        return new ProductException("name.null");
    }
    public static ProductException priceIsNull(){
        return new ProductException("price.null");
    }
    public static ProductException qtyIsNull(){
        return new ProductException("qty.null");
    }
    public static ProductException pricePUIncorrect(){
        return new ProductException("pricePU.incorrect");
    }
    public static ProductException qtyIncorrect(){
        return new ProductException("qty.incorrect");
    }

    //Not Found
    public static ProductException productNotFound(){
        return new ProductException("product.null");
    }

}
