package test08;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] nums = {2,3,1,5,-2,77,9};
        System.out.println(Arrays.toString(nums));
//        bubbleSort(nums);
//        selectSort(nums);
//        insertSort(nums);
//        shellSort(nums);
//        quickSOrt(nums,0,nums.length-1);
        radixSort1(nums);
        System.out.println(Arrays.toString(nums));
    }

    //基数排序

    public static void radixSort1(int[] nums){
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

    public static void radixSort(int[] nums){
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
            }
        }
        int maxLength = (max+"").length();
        int[][] bucket = new int[10][nums.length];
        int[] bucketElementCount = new int[10];
        for (int i = 0,n = 1; i < maxLength; i++,n *= 10) {
            for (int j = 0; j < nums.length; j++) {
                int d = (nums[j] / n) % 10;
                bucket[d][bucketElementCount[d]] = nums[j];
                bucketElementCount[d]++;
            }
            int index = 0;
            for (int i1 = 0; i1 < bucket.length; i1++) {
                if (bucketElementCount[i1] != 0){
                    for (int j = 0; j < bucketElementCount[i1]; j++) {
                        nums[index++] = bucket[i1][j];
                    }
                    bucketElementCount[i1] = 0;
                }
            }
        }
    }

    //快排--->nlogn--->
    public static void quickSOrt(int[] nums,int low,int high){
        if (low > high) return;
        int i,j,temp;
        i = low;
        j = high;
        temp = nums[i];
        while (i < j){
            while (j > i && nums[j] >= temp){
                j--;
            }
            while (j > i && nums[i] <= temp){
                i++;
            }
            if (i < j){
                 int t = nums[i];
                 nums[i] = nums[j];
                 nums[j] = t;
            }
        }
        nums[low] = nums[i];
        nums[i] = temp;
        quickSOrt(nums,low,i-1);
        quickSOrt(nums,i+1,high);
    }


    //希尔排序--->nlogn--->
    public static void shellSort(int[] nums){
        int length = nums.length;
        for (int gap = length/2;gap > 0;gap /= 2){
            for (int i = gap;i < length;i++){
                int temp = nums[i];
                int index = i - gap;
                while (index >= 0 && temp < nums[index]){
                    nums[index+gap] = nums[index];
                    index -= gap;
                }
                nums[index+gap] = temp;
            }
        }
    }


    //插入排序--->n2--->稳定
    public static void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int index = i - 1;
            while (index >= 0 && temp < nums[index]){
                nums[index+1] = nums[index];
                index--;
            }
            nums[++index] = temp;
        }
    }

    //选择--->n2--->不稳定
    public static void selectSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            int min = nums[i];
            int minINdex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < min){
                    min = nums[j];
                    minINdex = j;
                }
            }
            if (minINdex != i){
                nums[minINdex] = nums[i];
                nums[i] = min;
            }
        }
    }


    //冒泡--->n2--->稳定
    public static void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}