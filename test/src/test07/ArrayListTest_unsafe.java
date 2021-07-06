package test07;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayListTest_unsafe {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());


        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
