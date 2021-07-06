package test07;

import java.util.*;

//class ListNode {
//  int val;
//  ListNode next = null;
//}


import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null && str.length() > 0) {
            String[] split = str.split(",");
            int[] nums = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                nums[i] = Integer.parseInt(split[i].trim());
            }
            Arrays.sort(nums);
            int n = Integer.parseInt(br.readLine());
            int[] res = f(nums, n);
            StringBuilder sb = new StringBuilder();
            for (int i = res.length - 1; i >= 0; i--) {
                sb.append(res[i]).append(",");
            }
            System.out.println(sb.toString().substring(0,sb.length()-1));
        }
    }

    public static int[] f(int[] nums,int n){
        int[] res = new int[n];
        for (int i = nums.length - 1; i >= 0; i--) {
            res[0] += nums[i];
            Arrays.sort(res);
        }
        return res;
    }
}

