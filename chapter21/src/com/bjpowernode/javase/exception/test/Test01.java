package com.bjpowernode.javase.exception.test;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Test01 test01 = new Test01();
        test01.dosome();
        test01.dosome1();
    }

    public void dosome()  {

        System.out.println("dosome...");

        try {
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dosome1() throws ArithmeticException{

        System.out.println("dosome1...");
    }
}
