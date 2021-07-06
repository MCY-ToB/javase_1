package thread_4;

public class Thread_2  {
    public static void main(String[] args) {
        new Thread(new MyThread_2()).start();
    }
}

class MyThread_2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread_2");
    }
}
