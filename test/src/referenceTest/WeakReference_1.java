package referenceTest;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReference_1 {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        WeakReference<Object> reference = new WeakReference<>(o1,queue);

        System.out.println(o1);
        System.out.println(reference.get());
        System.out.println("queue.poll() = " + queue.poll());

        o1 = null;
        System.out.println("====GC之后====");
        System.gc();

        System.out.println(o1);
        System.out.println(reference.get());
        System.out.println("queue.poll() = " + queue.poll());
    }
}
