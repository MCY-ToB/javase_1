package test06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        List<Integer> res = f(nums);
        System.out.println(res.size());
        StringBuilder sb = new StringBuilder();
        for (Integer re : res) {
            sb.append(re).append(" ");
        }
        System.out.println(sb.toString().substring(0,sb.length()-1));
    }

    public static List<Integer> f(int[] nums){
//        for (int i = nums.length - 1; i >= 1; i--) {
//            while (i-1 >= 0 && nums[i] > nums[i-1]){
//                nums[i-1] = -1;
//                i--;
//            }
//        }
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != -1){
//                list.add(nums[i]);
//            }
//        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if(stack.isEmpty() || nums[i] <= stack.peek()){
                stack.push(nums[i]);
            }else {
                while (!stack.isEmpty() && nums[i] > stack.peek()){
                    stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(0,stack.pop());
        }
        return list;
    }

}