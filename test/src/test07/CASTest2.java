package test07;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASTest2 {
    static AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
        new Thread(() ->{
            int stamp = atomicReference.getStamp();
            System.out.println("t1获得的版本号："+stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet(100,101,atomicReference.getStamp(),atomicReference.getStamp()+1);
            atomicReference.compareAndSet(101,100,atomicReference.getStamp(),atomicReference.getStamp()+1);
        },"t1").start();

        new Thread(() ->{
            int stamp = atomicReference.getStamp();
            System.out.println("t2获得的版本号："+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(atomicReference.compareAndSet(100, 2021,atomicReference.getStamp(),atomicReference.getStamp()+1));
            System.out.println(atomicReference.compareAndSet(100, 2021,stamp,stamp+1));

//            atomicReference.compareAndSet(101,100,2,1);
        },"t2").start();
    }
}



//class Student{
//    private String name;
//    private int age;
//
//    public Student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}
