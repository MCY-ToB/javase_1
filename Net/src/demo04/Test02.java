package demo04;

import java.util.function.Predicate;

//要求选出名字为四个字并且性别为女
public class Test02 {
    public static void main(String[] args) {
        String[] arr = {"古力娜扎,女","彭于晏,男","迪丽热巴,女","赵丽颖,女"};

        printInfo(arr,
        s->  s.split(",")[0].length() == 4,
        (s)->{
            return s.split(",")[1].equals("女");
        });
    }

    public static void printInfo(String[] arr, Predicate<String> pre1,Predicate<String> pre2){
        for (String s :
                arr) {
            if (pre1.and(pre2).test(s)){
                System.out.println(s);
            }
        }
    }
}
