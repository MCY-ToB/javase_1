package jvmtest;

public class JpsTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello GC");
        Thread.sleep(Integer.MAX_VALUE);

//        long totalMemory = Runtime.getRuntime().totalMemory();
//        long maxMemory = Runtime.getRuntime().maxMemory();
//        System.out.println("totalMemory = " + totalMemory/1024/1024);
//        System.out.println("maxMemory = " + maxMemory/1024/1024);
    }
}
