package test04;

import java.util.Arrays;
        import java.util.LinkedList;

public class Main02 {
    public static void main(String[] args) {
//        示例 1：
//        输入：nums = [2,6,4,8,10,9,15]
//        输出：5
//        int[] nums = {2,6,4,8,10,9,15};
//        int[] shortArray = shortArray(nums);
//        System.out.println(Arrays.toString(nums)+"-->"+Arrays.toString(shortArray)+"\t长度为"+shortArray.length);

//        示例 2：
//        输入：nums = [1,2,3,4]
//        输出：0
//        int[] nums = {1,2,3,4};
//        int[] shortArray = shortArray(nums);
//        System.out.println(Arrays.toString(nums)+"-->"+Arrays.toString(shortArray)+"\t长度为"+shortArray.length);

//        示例 3：
//        输入：nums = [1]
//        输出：0
        int[] nums = {1};
        int[] shortArray = shortArray(nums);
        System.out.println(Arrays.toString(nums)+"-->"+Arrays.toString(shortArray)+"\t长度为"+shortArray.length);

    }

    //寻找并返回最小连续子数组
    public static int[] shortArray(int[] nums){
        int[] sort_nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sort_nums[i] = nums[i];
        }
        Arrays.sort(sort_nums);

        boolean flag = true;
        int min = 0,max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sort_nums[i] != nums[i]){
                if (flag){
                    min = i;
                    flag = false;
                }else {
                    max = i;
                }
            }
        }

        if (max == min){
            //max == min说明排序后的数组与原数组一致
            return new int[0];
        }else{
            int[] shortArray = new int[max-min+1];
            System.arraycopy(nums,min,shortArray,0,max-min+1);
            return shortArray;
        }
    }
}
