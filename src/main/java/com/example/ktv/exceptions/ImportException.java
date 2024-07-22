package com.example.ktv.exceptions;

public class ImportException extends BaseException{
    public ImportException(String code) {
        super("import."+code);
    }
    public static ImportException importDateIsNull(){
        return new ImportException("importDate.null");
    }
}
