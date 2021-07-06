package test06;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 样例输入
4 4 2 2 2
0 -1 1 2
3 1 5 1
1 -1 -1 -1
1 1 -1 0
样例输出
6*/
public class Main01{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        int x = Integer.parseInt(s[3]);
        int y = Integer.parseInt(s[4]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }
        int sum = matrix[x][y];


//        for (int[] ints : matrix) {
//            for (int anInt : ints) {
//                System.out.print(anInt+" ");
//            }
//            System.out.println();
//        }
    }
    //获取最大值
    public static int[] getMax(int[][] matrix,int x,int y){
        int max = -1;
        int left = -1;
        int right = -1;
        int up = -1;
        int down = -1;
        if(x-1 >= 0){
            left = matrix[x-1][y];
            max = Math.max(max,left);
        }
        if(x+1 < matrix[0].length){
            right = matrix[x+1][y];
            max = Math.max(max,right);
        }
        if(y-1 >= 0){
            up = matrix[x][y-1];
            max = Math.max(max,up);
        }
        if(y+1 < matrix.length){
            down = matrix[x][y+1];
            max = Math.max(max,down);
        }
        if (max == left){
            return new int[]{max,x-1,y};
        }
        if (max == right){
            return new int[]{max,x+1,y};
        }
        if (max == up){
            return new int[]{max,x,y-1};
        }
        if (max == down){
            return new int[]{max,x,y+1};
        }
        return new int[]{max,x,y};
    }
    //判断可不可以到此，返回true表示可以
    //x,y表示洞口
    //i,j表示要到达的地方
    //k表示剩余的步数
    public static boolean isOK(int x,int y,int i,int j,int k){
        int sum = 0;
        sum += Math.abs(x-i);
        sum += Math.abs(y-j);
        return sum <= k;
    }
}
