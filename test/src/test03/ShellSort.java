package test03;

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
//        shellSort(nums);//7s
        shellSort2(nums);
//        MySort(nums);   //4s
        Date date2 = new Date();
        System.out.println(sdf.format(date2));
        System.out.println("nums = " + Arrays.toString(nums));
    }
    //交换式
    public static void shellSort(int[] nums){
        int length = nums.length;
        for(int gap = length / 2;gap > 0;gap /= 2){
            for (int i = gap; i < length; i++) {
                for(int j = i - gap;j >= 0;j -= gap){
                    if (nums[j] > nums[j+gap]){
                        int temp = nums[j];
                        nums[j] = nums[j+gap];
                        nums[j+gap] = temp;
                    }
                }
            }
        }
    }
    //移位式
    public static void shellSort2(int[] nums){
        int length = nums.length;
        for(int gap = length / 2;gap > 0;gap /= 2){
            for (int i = gap;i < length;i++){
                int j = i;
                int temp = nums[j];
                while(j - gap >= 0 && temp < nums[j-gap]){
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = temp;
            }
        }
    }
}
