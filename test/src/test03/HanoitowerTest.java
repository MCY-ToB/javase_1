package test03;

public class HanoitowerTest {
    public static void main(String[] args) {
        hanoitower(15,'a','b','c');
    }
    static int count = 0;
    public static void hanoitower(int num,char a,char b,char c){
        if (num == 1){
            //只有一个盘时直接从a->c
            System.out.println("第1个盘从"+a+"->"+c);
        }else {
            //将（n-1）个盘从a->b
            hanoitower(num-1,a,c,b);
            //将第n个盘从a->c
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //将（n-1）个盘从b->c
            hanoitower(num-1,b,a,c);
        }
    }
}
