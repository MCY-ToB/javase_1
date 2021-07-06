package test02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test04 {
    public static void main(String[] args) {
        /*class Solution {
            public List<List<Integer>> generate(int numRows) {

            }
        }*/

        int numRows = 5;
//        int index = 0;
        List list = new ArrayList<List<Integer>>();
        Integer[] t_arr = null;
        Integer[] arr = null;

        for (int i = 0; i < 5; i++) {
             arr = new Integer[i+1];
            for (int j = 0; j < arr.length; j++) {
                if (j == 0 || j == (arr.length - 1)) {
                    arr[j] = 1;
                } else {
                    arr[j] = t_arr[j-1] + t_arr[j];
                }
            }
            t_arr = arr;
//            List<Integer> a_list = Arrays.asList(arr);

        }
        System.out.println(arr);
    }
}
