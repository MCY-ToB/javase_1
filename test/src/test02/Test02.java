package test02;

import java.util.Arrays;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        /*int[] arr =  {3,21,43,-4};
        Arrays.sort(arr);
        for (int x :
                arr) {
            System.out.println(x);
        }

        String s = Arrays.toString(arr);
        System.out.println(s);
        for(int i = 0;i < arr.length;i = i + 2){
            System.out.println(arr[i]);
        }*/
        /*String[] strArr = {"刘雯","胡歌","杜鹃","邓伦"};//原数组元素
        List<String> strings = Arrays.asList(strArr);
//        List<String> list = Arrays.asList(strArr);
        System.out.println(strings);*/

//        int[] arr = new int[]{1,2,3};
//        List<int[]> ints = Arrays.asList(arr);
//
//        int[] arr2 = {1,2,3};
//        List<int[]> ints1 = Arrays.asList(arr2);
//
//        Integer[] arr3 = {1,2,3};
//        List<Integer> integers = Arrays.asList(arr3);

    }
}

class A  {
    public A get(){
        A a = null;
        try {
            a = (A)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return a;
    }
}
