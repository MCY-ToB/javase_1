package deadLock;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.TimeUnit;

public class DeadLock_1 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        new Thread(() -> {
            synchronized (o1){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+"\t执行完毕");
                }
            }
        }).start();
        System.out.println("===========");
        new Thread(() -> {
            synchronized (o2){
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+"\t执行完毕");
                }
            }
        }).start();
    }
}
