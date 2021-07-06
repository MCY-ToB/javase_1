package demo05;

import java.util.function.Function;

public class FunctionTest02 {
    public static void main(String[] args) {
        String s = "123";
        String change = change(s,
                (String str) -> {
                    return Integer.parseInt(str) + 1;
                },
                (Integer num) -> {
                    return String.valueOf(num) + "999";
                });

        System.out.println(change);
    }
    public static String change(String s, Function<String,Integer> fun1,Function<Integer,String> fun2){
//        return fun1.andThen(fun2).apply(s);//==>
        Integer apply = fun1.apply(s);
        return fun2.apply(apply);
    }
}
