package test03;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
        int[] nums = new int[8000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 8000000);
        }
//        System.out.println("nums = " + Arrays.toString(nums));
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(date1));

        radixSort(nums);

        Date date2 = new Date();
        System.out.println(sdf.format(date2));
//        System.out.println("nums = " + Arrays.toString(nums));
    }
    public static void radixSort(int[] nums){
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
            }
        }
        int maxLength = (max+"").length();
        int[][] bucket = new int[10][nums.length];
        int[] bucketElementCount = new int[10];
        for (int i = 0,n = 1;i < maxLength;i++,n *= 10){
            for (int j = 0; j < nums.length; j++) {
                int d = (nums[j] / n) % 10;
                bucket[d][bucketElementCount[d]] = nums[j];
                bucketElementCount[d]++;
            }

            int index = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k] != 0) {
                    //不为零则遍历
                    for (int j = 0; j < bucketElementCount[k]; j++) {
                        nums[index++] = bucket[k][j];
                    }
                }
                bucketElementCount[k] = 0;
            }
        }
    }
}
