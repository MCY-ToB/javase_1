package test01;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Test_9 {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        ts.add(23);
        ts.add(23);
        ts.add(2);
        ts.add(3);
        ts.add(230);

        /*for (Integer i :
                ts) {
            System.out.println(i);
        }*/

        Iterator<Integer> iterator = ts.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
class A implements Comparator<Integer>{


    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
