package test07;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test01 {
    public static void main(String[] args) {
        Single01 single01 = Single01.INSTANCE;
        Single01 single02 = Single01.INSTANCE;
        System.out.println(single01 == single02);
    }
    @Test
    public void t1(){
//        String a = "abc";
//        String b = "abc";
//        String a = new String("abc");
//        String b = new String("abc");
//        System.out.println(a == b);
        String s = "1 2 34 5";
        String[] s1 = s.split(" ");
        System.out.println(s1.length);
        for (String s2 : s1) {
            System.out.println(s2);
        }
    }
    @Test
    public void t2(){
//        int a = 1234;
////        System.out.println(String.valueOf(a).length());
//        System.out.println((a + "").length());
//        String s = ",,   ,a,,b,c,,,,";
//        String[] split = s.split(",");
//        System.out.println("split.length = " + split.length);
//        for (String s1 : split) {
//            System.out.println(s1+1);
//        }
//        String phone = "A1A";
//        System.out.println(phone.matches("^[ASWD]\\d{1,2}$"));
//        String s = "1 2  3";
//        System.out.println(s.split(" ").length);
//        for (String s1 : s.split(" ")) {
//            System.out.println(s1 + "\t"+ s1.length());
//        }
        String s = "abc abc)abc&abc  %%abc";
        String[] split = s.split("^[^a-zA-Z]$");
        System.out.println(split.length);
        for (String s1 : split) {
            System.out.println(s1);
        }
    }
    @Test
    public void t3(){
        int[] nums = {1,2,3,4};
        int[] ints = Arrays.copyOfRange(nums, 0, 4);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void t4(){
        int i = 1;
        i = 1 + i;
        System.out.println(i);
    }

    @Test
    public void t5(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(11111);
            }
        };
        r1.run();
        System.out.println("=============");
        Runnable r2 = () -> System.out.println(2222);
        r2.run();
        System.out.println("=============");
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println("c.compare(11,22) = " + c.compare(11, 22));
        System.out.println("=============");
        Comparator<Integer> c2 = (o1,o2)->Integer.compare(o1,o2);
        System.out.println("c2.compare(33,22) = " + c2.compare(33, 22));
        System.out.println("=============");
        Comparator<Integer> c3 = Integer::compareTo;
        System.out.println("c3.compare(33,22) = " + c3.compare(33, 22));
    }

    @Test
    public void t6(){
        try {
            System.out.println("try");
            int a = 8 / 0;
//            System.exit(0);
            System.out.println("try 2");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            int a = 8 / 0;
            System.out.println("ArithmeticException异常");
        }finally {
            System.out.println("finally");
        }
    }

    @Test
    public void t7(){
        AtomicInteger integer = new AtomicInteger(0);
        System.out.println(integer.incrementAndGet());
    }

    @Test
    public void t8(){
       HashMap<Integer,Integer> map = new HashMap<>();
       map.put(1,1);
       map.put(2,1);
       System.out.println(map);
    }
}
