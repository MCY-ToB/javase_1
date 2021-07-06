package test08;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class iTest {
//    static AtomicInteger x = new AtomicInteger(0);

    static volatile int x = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
//                    x.getAndIncrement();
                    x++;
                }
            }, String.valueOf(i)).start();
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(x);
    }
}
