package threadpool;

import com.sun.jmx.snmp.tasks.ThreadService;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;
//当核心线程数都在执行并且阻塞队列已满时，有新的任务进来，则新来的任务会由新开的线程立刻运行
public class ThreadPool_1 {
    public static void main(String[] args) {
        ExecutorService threadService = new ThreadPoolExecutor(2,5,100l, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());

        try {
            for (int i = 1; i <= 10; i++) {
                final int temp = i;
                threadService.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"号窗口服务"+temp);
                    try {
                        TimeUnit.SECONDS.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadService.shutdown();
        }
    }
}
