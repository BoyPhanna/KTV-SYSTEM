package com.example.ktv.exceptions;

public class ImageExecption extends BaseException{
    public ImageExecption(String code) {
        super("image."+code);
    }
    public static ImageExecption fileNotSupport(){
        return new  ImageExecption("file.type.not-support");
    }
    public static ImageExecption fileIsNull(){
        return new ImageExecption("file.is-null");
    }


}
