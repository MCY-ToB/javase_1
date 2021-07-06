package test07;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.set(finalI, finalI);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.get(finalI);
            }, String.valueOf(i)).start();
        }
    }
}
//资源类
class MyCache{
    private Map<Integer,Integer> map = new HashMap<>();

//    ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void set(Integer key,Integer value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t正在写入:"+key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"\t写入完成");
        }finally {
            lock.writeLock().unlock();
        }
    }

    public void get(Integer key){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t正在读取");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer value = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t读取完成:"+value);
        }finally {
            lock.readLock().unlock();
        }
    }
}