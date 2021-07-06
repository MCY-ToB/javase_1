package test01;

import java.util.HashSet;
import java.util.Set;

public class Test_6 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.addDigits(38);
        System.out.println(i);
    }
}
class Solution {
    public int addDigits(int num) {
        HashSet<Integer> set = new HashSet();
        while(num >= 10 && !set.contains(num)){
            set.add(num);
            num = getNext(num);
        }

        return num < 10 ? num : 0;
    }

    public int getNext(int n){
        int sum = 0;
        while(n != 0){
            int d = n % 10;
            n /= 10;
            sum += d;
        }
        return sum;
    }
}
