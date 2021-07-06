package test08;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Test01 {
    @Test
    public void t1(){
        for (int i = 0; i < 10; i += 5) {
            int j = i;
            j--;
            System.out.println(j);
        }
    }

    @Test
    public void t2() throws InterruptedException {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(() ->{
            try {
                queue.put("1");
                System.out.println(Thread.currentThread().getName()+"\tput 1");
                queue.put("2");
                System.out.println(Thread.currentThread().getName()+"\tput 2");
                queue.put("3");
                System.out.println(Thread.currentThread().getName()+"\tput 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(5);
                queue.take();
                System.out.println(Thread.currentThread().getName()+"\ttake 1");

                TimeUnit.SECONDS.sleep(5);
                queue.take();
                System.out.println(Thread.currentThread().getName()+"\ttake 2");

                TimeUnit.SECONDS.sleep(5);
                queue.take();
                System.out.println(Thread.currentThread().getName()+"\ttake 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }

    @Test
    public void t3(){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void t4(){
       String s = "abcde";
        System.out.println(s.substring(0,2)+s.substring(3));

    }
}
