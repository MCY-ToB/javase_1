package sorttest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {

    public static void main(String[] args) {

//        int[] nums = {2,3,1,88,44,66,-3};
//        System.out.println(Arrays.toString(nums));
//        shellSort2(nums);
//        System.out.println(Arrays.toString(nums));

        int[] arr = new int[8888];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * 800000));
        }
        System.out.println(Arrays.toString(arr));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date date1 = new Date();
        System.out.println(sdf.format(date1));
//        bubblesort(arr);   //2021-04-17 15:14:36 700  2021-04-17 15:14:37 684
//        selectSort(arr);//2021-04-17 15:15:38 915     2021-04-17 15:15:39 162
//        insertSort(arr);  2021-04-17 15:16:35 435    2021-04-17 15:16:35 511
//        shellSort(arr);2021-04-17 15:17:38 623      2021-04-17 15:17:39 234
//        shellSort2(arr);2021-04-17 15:18:24 470     2021-04-17 15:18:24 479
//        shellSort2(arr);
        quickSort(arr,0,arr.length-1);
        Date date2 = new Date();
        System.out.println(sdf.format(date2));
        System.out.println(Arrays.toString(arr));
    }

    //快速排序
    public static void quickSort(int[] nums,int low,int high){
        if (low > high) return;
        int i = low;
        int j = high;
        int temp = nums[low];
        while (i < j){
            while (i < j && nums[j] >= temp){
                j--;
            }
            while (i < j && nums[i] <= temp){
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
        quickSort(nums,low,i-1);
        quickSort(nums,i+1,high);
    }

    //基数排序（桶排序）
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

    //希尔排序--->移位式
    public static void shellSort2(int[] nums){
        int length = nums.length;
        for (int gap = length / 2;gap > 0;gap /= 2){
            for (int i = gap;i < length;i++){
                int index = i - gap;
                int temp = nums[i];
                while(index >= 0 && temp < nums[index]){
                    nums[index+gap] = nums[index];
                    index -= gap;
                }
                if (index + gap != i){
                    nums[index+gap] = temp;
                }
            }
        }
    }

    //希尔排序--->交换式
    public static void shellSort(int[] nums){
        int length = nums.length;
        for (int gap = length / 2;gap > 0;gap /= 2){
            for (int i = gap;i < length;i++){
                for(int j = i - gap;j >= 0;j -= gap){
                    if (nums[j] > nums[j + gap]){
                        int temp = nums[j];
                        nums[j] = nums[j+gap];
                        nums[j+gap] = temp;
                    }
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int index = i - 1;
            while (index >= 0 && temp < nums[index]){
                nums[index+1] = nums[index];
                index--;
            }
            if (index + 1 != i) {
                nums[++index] = temp;
            }
        }
    }

    //选择排序
    public static void selectSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min){
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    //冒泡排序
    public static void bubblesort(int[] nums){
        boolean flag;
        for (int i = 0; i < nums.length - 1; i++) {
            flag = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }
}
