package test02;

import java.util.Arrays;
import java.util.Random;

public class Test08 {
    public static void main(String[] args) {
        int[] arr = new int[9999];
        for (int i = 0; i < 9999; i++) {
            arr[i] = (int)(Math.random() * 80000);
        }
        MySort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] MySort (int[] arr) {
        // write code here
        //选择排序

        for(int i = 0;i < arr.length - 1;i++){
            int min = arr[i];
            int minIndex = i;
            for(int j = i + 1;j < arr.length;j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
