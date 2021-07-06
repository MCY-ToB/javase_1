package test02;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[80000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 80000);
        }
        System.out.println("nums = " + Arrays.toString(nums));
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(date1));
//        quickSort(nums,0,nums.length-1);
        shellSort(nums);
        Date date2 = new Date();
        System.out.println(sdf.format(date2));
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public static void shellSort(int[] arr){
        int len = arr.length;
        for(int gap = len/2;gap > 0;gap /= 2){
            for(int i = gap;i < len;i++){
                int j = i;
                int temp = arr[i];
                while(j - gap >= 0 && arr[j-gap] > temp){
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }
}
