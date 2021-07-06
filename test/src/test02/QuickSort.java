package test02;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[80000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 80000);
        }
        System.out.println("nums = " + Arrays.toString(nums));
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(date1));
        quickSort(nums,0,nums.length-1);
        Date date2 = new Date();
        System.out.println(sdf.format(date2));
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public static void quickSort(int[] arr,int low,int high){
        if(low >= high) return;
        int left = low,right = high,temp = arr[low];
        while(left < right){
            while(left < right && arr[right] <= temp){
                right--;
            }
            while(left < right && arr[left] >= temp){
                left++;
            }
            if(left < right){
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
            }
        }
        arr[low] = arr[left];
        arr[left] = temp;
        quickSort(arr,low,left-1);
        quickSort(arr,left+1,high);
    }
}
