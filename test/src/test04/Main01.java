package test04;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;
        import java.util.Scanner;
public class Main01{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> map = new HashMap<>();
        while(in.hasNextInt()){
            int n = in.nextInt();
            if (n == 0) break;
            for(int i = 0;i < n;i++){

                    String[] nums = reader.readLine().split(" ");
                    if (map.containsKey(Integer.valueOf(nums[0]))) {
                        int value = map.get(Integer.valueOf(nums[0])) + Integer.valueOf(nums[1]);
                        map.put(Integer.valueOf(nums[0]),value);
                    }else{
                        map.put(Integer.valueOf(nums[0]),Integer.valueOf(nums[1]));
                    }

            }
            Set<Integer> set = map.keySet();
            for (Integer integer : set) {
                System.out.println(integer+" "+map.get(integer));
            }
            map.clear();
        }
    }
}