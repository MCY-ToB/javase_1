package thread_4;

public class Thread_1 {
    public static void main(String[] args) {
        new MyThread_1().start();
    }
}

class MyThread_1 extends Thread{
    @Override
    public void run() {
        System.out.println("---->run");
    }
}
