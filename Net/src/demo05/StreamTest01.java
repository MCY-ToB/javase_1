package demo05;

import java.util.ArrayList;

public class StreamTest01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("麦楚扬");
        list.add("麦楚欣");
        list.add("麦麦楚扬");
        list.add("余楚扬");

        list.stream()
                .filter(string->  string.startsWith("麦"))
                .filter((String string)->{
                    return string.length() == 3;
                })
                .forEach(s -> System.out.println(s));
    }
}
