package test03;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//插入排序
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[80000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 80000);
        }
//        System.out.println("nums = " + Arrays.toString(nums));
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(date1));

        insertSort(nums);

        Date date2 = new Date();
        System.out.println(sdf.format(date2));
//        System.out.println("nums = " + Arrays.toString(nums));
    }
    public static void insertSort(int[] nums){
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int temp = nums[i];
            int index = i - 1;
            while (index >= 0 && temp < nums[index]){
                nums[index+1] = nums[index];
                index--;
            }
            if (index + 1 != i){
                nums[index+1] = temp;
            }
        }
    }
}
