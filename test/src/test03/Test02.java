package test03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        List list = new ArrayList();

    }
}
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
 class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        int length = num.length;

        for(int i = 0;i < length-2;i++){
            for(int j = i+1;j < length - 1;j++){
                for(int k = j+1;k < length;k++){
                    if(num[i] + num[j] + num[k] == 0){
                        ArrayList<Integer> list1 = new ArrayList<Integer>();
                        list1.add(num[i]);
                        list1.add(num[j]);
                        list1.add(num[k]);
                        list.add(list1);
                    }
                }
            }
        }

        return list;
    }
}
