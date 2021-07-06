package test08;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        while (true){
            if (myThread.isFlag()){
                System.out.println("主线程输出");
            }
        }
    }

}

class MyThread extends Thread{
    private volatile boolean flag = false;
    public boolean isFlag(){
        return flag;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + flag);
    }
}