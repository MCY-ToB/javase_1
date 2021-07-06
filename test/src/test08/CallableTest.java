package test08;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new MyThread1());
        Thread t1 = new Thread(futureTask,"AA");
//        System.out.println("futureTask.get() = " + futureTask.get());
        t1.start();
        System.out.println("futureTask.get() = " + futureTask.get());
    }
}

class MyThread1 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("call 执行");
        return 1024;
    }
}