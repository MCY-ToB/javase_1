package test03;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {
//        List list = new ArrayList();
//        Student student1 = new Student("张三");
//        Student student2 = new Student("张三");
//        list.add(student1);
//        System.out.println(list.contains(student2));
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("遍历之前集合长度："+list.size());
//        list.remove(1);
        list.remove(new Integer(1));
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println("遍历之前集合长度："+list.size());

    }
}

