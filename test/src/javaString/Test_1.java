package javaString;

public class Test_1 {
    public static void main(String[] args) {
        String sb1 = new StringBuilder("58").append("tongcheng").toString();
        String intern1 = sb1.intern();
        System.out.println("sb1 = " + sb1);
        System.out.println("intern1 = " + intern1);
        System.out.println(sb1 == intern1);
        System.out.println("==============");
        String sb2 = new StringBuilder("ja").append("va").toString();
        String intern2 = sb2.intern();
        System.out.println("sb2 = " + sb2);
        System.out.println("intern2 = " + intern2);
        System.out.println(sb2 == intern2);
    }
}
