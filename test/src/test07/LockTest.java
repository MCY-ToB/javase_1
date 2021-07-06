package test07;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                phone.sendMSM();
//            }, String.valueOf(i)).start();
//        }
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                phone.sendEmail();
//            }, String.valueOf(i)).start();
//        }
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                phone.sendMSM();
//            }, String.valueOf(i)).start();
//        }
//        new Thread(() ->{
//            phone.sendEmail();
//        },"t2").start();
//
//        new Thread(() ->{
//            phone.sendMSM();
//        },"t1").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(() -> {
//
//        }).start();

        Thread t3 = new Thread(phone,"t3");
        t3.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phone.set();
    }
}

class Phone implements Runnable{
    public synchronized void sendMSM(){
        System.out.println(Thread.currentThread().getName()+"\tsendMSM()");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"\tsendEmail()");
    }

    @Override
    public void run() {
        get();
    }
    Lock lock = new ReentrantLock();//非公平锁
    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\tget()");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            set();
        }finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\tset()");
        }finally {
            lock.unlock();
        }
    }
}
