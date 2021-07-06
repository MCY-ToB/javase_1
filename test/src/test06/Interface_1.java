package test06;

import org.junit.Test;
import singleton.Singleton_6;

import java.util.*;

public interface Interface_1 {
    final public static int i = 111;
    public default String f1(){
        int b = 3;
        return "abc";
    }

    public static String f2(){
        int a = 2;
        return "abc";
    }

}

class C{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[]values=line.split(",");
        int[]s=new int[values.length];
        for(int i=0;i<values.length;i++){
            s[i] = Integer.parseInt(values[i]);
        }

        line = scanner.nextLine();
        values=line.split(",");
        int[]t=new int[values.length];
        for(int i=0;i<values.length;i++){
            t[i] = Integer.parseInt(values[i]);
        }

        res = winner(s, t);
        System.out.println(String.valueOf(res));

    }

    static int winner(int[] s, int[] t) {
        int[] nums = new int[s.length];
        List<Integer> list = new ArrayList<>();
        for (int i : t) {
            list.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(s[i])){
                nums[i] = s[i];
            }else{
                nums[i] = 0;
            }
        }

        int minLength = nums.length;
        int minIndex = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                List<Integer> list1 = new ArrayList<>();
                for (int j = i; j < nums.length; j++) {
                    if (f(list1,t) && list1.size() < minLength){//包含每一个元素
                        minLength = list1.size();
                        if(list1.size() == t.length){
                            return j-list1.size()+1;
                        }else{
                            minIndex = j-list1.size()+1;
                        }
                    }else {
                        list1.add(nums[j]);
                    }
                }
            }
        }
        return minIndex == nums.length ? 0 : minIndex;
    }
    //判断是否包含每一个元素
    public static boolean f(List list,int[] t){
        for (int i : t) {
            if (!list.contains(i)){
                return false;
            }
        }
        return true;
    }

}

class SingleTon{
    private SingleTon(){}
    private static volatile SingleTon INSTANCE;
    public static SingleTon getSingleTon(){
        if (INSTANCE == null){
            synchronized (SingleTon.class){
                if (INSTANCE == null){
                    INSTANCE = new SingleTon();
                }
            }
            return INSTANCE;
        }
        return INSTANCE;
    }
}


