package test07;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class SingletonTest {
    public static SingletonTest single = null;
    private SingletonTest(){
        System.out.println(Thread.currentThread().getName()+"\t执行私有化构造方法");
    }
    //DCL（double checked lock）--->双端检锁机制
    public  static SingletonTest getInstance(){
        if (single == null){
            synchronized (SingletonTest.class){
                if (single == null){
                    single = new SingletonTest();
                }
            }
        }
        return single;
    }

    public static void main(String[] args) {
//        System.out.println(getInstance() == getInstance());
//        System.out.println(getInstance() == getInstance());
//        System.out.println(getInstance() == getInstance());
//        System.out.println("================");

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
