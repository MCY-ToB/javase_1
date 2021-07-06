package jvmtest;

public class StackOverTest {
    static int count = 0;

    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(count);
        }
    }

    public static void method(){
        count++;
        method();
    }
}
