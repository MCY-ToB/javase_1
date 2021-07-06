package test01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class test_02 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("abc");
        c.add("def");
        c.add("xyz");
        System.out.println(c.size());
        //获取迭代器
        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
            iterator.remove();
        }
        System.out.println(c.size());
    }
}
