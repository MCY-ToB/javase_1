package test01;

import java.util.*;


public class Test_3 {
    /**
     * reverse string
     * @param str string字符串 the stirng
     * @return string字符串
     */
    public static void main(String[] args) {
        String s = "i am a student";
        System.out.println("reverseStringI(s) = " + reverseStringI(s));

    }
    public static String reverseStringI (String str) {
        // write code here
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < strs.length;i++){
            sb.append(f(strs[i])+" ");
        }
        return sb.toString().substring(0,sb.toString().length()-1);
    }
    //翻转
    public static String f(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1;i >= 0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
