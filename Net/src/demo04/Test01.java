package demo04;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test01 {
    public static void main(String[] args) {

        String[] arr = {"麦楚扬,男","沈钊宇,女","余培娜,女"};
        printinfo(
        (s)->{
            System.out.print("姓名:" + s.split(",")[0]);
        },
        (s)->{
            System.out.println("\t性别:" + s.split(",")[1]);
        },
        arr);
    }
    public static void printinfo(Consumer<String> con1,Consumer<String> con2,String[] arr){
        for (String s :
                arr) {
            con1.andThen(con2).accept(s);
        }
    }
}
