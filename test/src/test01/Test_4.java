package test01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test_4 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"zhangsan");
        map.put(2, "lisi");
        map.put(3,"wangwu");
        map.put(4,"zhaoliu");
      /*  Set<Integer> integers = map.keySet();
        for (int x:
             integers) {
            String s = map.get(x);
            System.out.println(s);
        }*/
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            next.setValue("mcy");
            System.out.println(next.getKey()+":"+next.getValue());
        }
    }
}
