package test02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
//    private static Object Integer;

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        System.out.println("remove之前："+list);
//        list.remove(0);
//        list.remove(2);
//        System.out.println("remove之后："+list);
//        System.out.println("add('9','0') = " + add('9', '0'));
//        System.out.println("add('8','7') = " + add('8', '7'));
        System.out.println("solve(\"99\",\"1\") = " + solve("99", "1"));
    }
    public static String solve (String s, String t) {
        // write code here
        int len1 = s.length(),len2 = t.length();
        int index = 0;
        int min = Math.min(len1,len2);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(index < min){
            int sum = add(s.charAt(index),t.charAt(index)) + carry;
            int d = sum % 10;
            carry = sum / 10;
            sb.append(d);
            index++;
        }
        while(min < len1){
            if(carry == 0){
                sb.append(s.substring(min,len1));
                return sb.reverse().toString();
            }
            sb.append(solve(s.substring(min,len1),"1"));
            return sb.reverse().toString();
        }
        while(min < len2){
            if(carry == 0){
                sb.append(s.substring(min,len2));
                return sb.reverse().toString();
            }
            sb.append(solve(s.substring(min,len2),"1"));
            return sb.reverse().toString();
        }
        return sb.append(carry).reverse().toString();
    }

    public static int add(char c1,char c2){
        return c1 + c2 - 96;
    }
    @Test
    public void t1() throws CloneNotSupportedException {
//        System.out.println("Math.sqrt(10) = " + Math.sqrt(10));
//        System.out.println((int)3.14);
        System.out.println("(-3)/2 = " + (-5.4) / 2);
        Object clone = clone();
    }
//
}





