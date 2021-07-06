package test02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test03 {
    public static void main(String[] args) {
        Map map = new HashMap<Integer, Integer>();
        map.put(1,3);
        map.put(2,5);
        map.put(3,7);
        map.put(4,9);
        int o = (Integer) map.get(4);
        System.out.println(map.size());

        Set set = map.keySet();
        for (Object x :
                set) {
            System.out.println(x+"==="+map.values());
        }

        double max = Math.max(1.2, 2.3);
    }
}
