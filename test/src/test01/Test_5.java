package test01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test_5 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(111,"zhangsan");
        map.put(222,"lisi");
        map.put(444,"wangwu");
        map.put(333,"zhaoliu");
        map.put(333,"king");

        System.out.println(map.size());
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry :
                entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
