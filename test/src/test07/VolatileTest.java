package test07;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
    public static void main(String[] args) {
        MyData myData = new MyData();

//        new Thread(
//                () -> {
//                    System.out.println(Thread.currentThread().getName()+"\tcome in");
//                    try {
//                        TimeUnit.SECONDS.sleep(3);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    myData.update();
//                    System.out.println(Thread.currentThread().getName()+"\tupdate value to:"+myData.number);
//                },
//                "AAA"
//        ).start();

//        while (myData.number == 0){
//
//        }
//
//        System.out.println(Thread.currentThread().getName()+"\tmission over!main get number:"+myData.number);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.add2();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(myData.atomicInteger);
    }
}

class MyData{
    volatile int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public  void update(){
        this.number = 99;
    }

    public void add(){
        number++;
    }

    public void add2(){
        atomicInteger.getAndIncrement();
    }
}
