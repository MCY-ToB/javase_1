package test02;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
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
//        shellSort(nums);
        int[] temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1,temp);
        Date date2 = new Date();
        System.out.println(sdf.format(date2));
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums,int start,int end,int[] temp){
        if(start < end){
            int mid = start + ((end-start) >> 1);
            mergeSort(nums,start,mid,temp);
            mergeSort(nums,mid+1,end,temp);
            merge(nums,start,mid,end,temp);
        }
    }

    //合并数组
    public static void merge(int[] nums,int left,int mid,int right,int[] temp){
        int p1 = left,p2 = mid+1,t = left;
        while(p1 <= mid && p2 <= right){
            if(nums[p1] <= nums[p2]){
                temp[t++] = nums[p1++];
            }else{
                temp[t++] = nums[p2++];
            }
        }
        while(p1 <= mid){
            temp[t++] = nums[p1++];
        }
        while (p2 <= right){
            temp[t++] = nums[p2++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i];
        }
    }
}
