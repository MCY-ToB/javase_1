package com.bjpowernode.javase.exception.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test02 {
    public static void main(String[] args) {
        NullPointerException nullPointerException = new NullPointerException("空指针异常");
        String message = nullPointerException.getMessage();
        System.out.println(message);

        nullPointerException.printStackTrace();
    }
}
