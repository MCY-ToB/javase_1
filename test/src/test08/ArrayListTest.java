package test08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class ArrayListTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(() ->{
            try {
                System.out.println(Thread.currentThread().getName()+"\tput 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName()+"\tput 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName()+"\tput 3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\ttake"+queue.take());

                TimeUnit.SECONDS.sleep(5);
                queue.take();
                System.out.println(Thread.currentThread().getName()+"\ttake"+queue.take());

                TimeUnit.SECONDS.sleep(5);
                queue.take();
                System.out.println(Thread.currentThread().getName()+"\ttake"+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
