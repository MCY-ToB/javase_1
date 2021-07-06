package thread_4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread_3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread_3());
        new Thread(futureTask).start();
        System.out.println("futureTask.get() = " + futureTask.get());//要在线程执行完才能获取到，否则程序会一直卡着
    }
}
class MyThread_3 implements Callable{
    @Override
    public Object call() throws Exception {
        return 111;
    }
}