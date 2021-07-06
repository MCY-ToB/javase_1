package test03;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] nums = new int[8000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 80000);
        }
//        System.out.println("nums = " + Arrays.toString(nums));
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(date1));

        int[] temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1,temp);

        Date date2 = new Date();
        System.out.println(sdf.format(date2));
//        System.out.println("nums = " + Arrays.toString(nums));

    }
    //归并排序
    public static void mergeSort(int[] a,int start,int end,int[] temp){
        if (start < end){
            int mid = (start + end) / 2;
            mergeSort(a,start,mid,temp);
            mergeSort(a,mid+1,end,temp);
            merge(a,start,mid,end,temp);
        }
    }
    //合并
    public static void merge(int[] a,int left,int mid,int right,int[] temp){

        int p1 = left,p2 = mid + 1,t = left;
        while (p1 <= mid && p2 <= right){
            if (a[p1] <= a[p2]){
                temp[t++] = a[p1++];
            }else {
                temp[t++] = a[p2++];
            }
        }
        while (p1 <= mid){
            temp[t++] = a[p1++];
        }
        while (p2 <= right){
            temp[t++] = a[p2++];
        }
        for (int i = left; i <= right; i++) {
            a[i] = temp[i];
        }
    }
}
