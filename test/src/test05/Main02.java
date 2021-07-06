package test05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(removal(s));
    }
    public static String removal(String s){
        Set<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))){
                continue;
            }else{
                set.add(s.charAt(i));
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
