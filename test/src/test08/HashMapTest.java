package test08;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap(12);
        for (int i = 0; i < 20; i++) {
            map.put(""+i,i);
        }
        System.out.println("map = " + map);
    }
}
