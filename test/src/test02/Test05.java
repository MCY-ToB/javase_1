package test02;

import java.util.Arrays;

public class Test05 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        //String[] s1 = s.split(" ");
        /*for (String x :
                s1) {
            System.out.println(x);
        }*/
        /*for (int i = 0; i < s.length(); i++) {

        }*/
        Test05 test05 = new Test05();
        System.out.println(test05.reserve("abc"));
    }

    //反转字符串
    public  String reserve(String s){
        char[] chars = s.toCharArray();
        int start = 0,end = chars.length -1;
        String new_s = "";

        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }

        for (int i = 0; i < chars.length; i++) {
            new_s += chars[i];
        }

        return new_s;
    }
}
