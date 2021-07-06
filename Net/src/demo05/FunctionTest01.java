package demo05;

import java.util.function.Function;

public class FunctionTest01 {
    public static void main(String[] args) {
        String s = "12345";
        System.out.println(change(s,(String str)->{
            return Integer.valueOf(str) + 1;
        }));
    }
    public static Integer change(String s, Function<String,Integer> function){
        return function.apply(s);
    }
}
