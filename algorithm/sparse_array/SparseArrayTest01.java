package algorithm.sparse_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SparseArrayTest01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null){
            String[] nums = str.split(" ");
            int rows = Integer.parseInt(nums[0]);
            int cols = Integer.parseInt(nums[1]);
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                String[] arrs = br.readLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Integer.parseInt(arrs[j]);
                }
            }
            printArray(matrix);
            System.out.println("转换为稀疏数组：");
            printArray(toSparseArray(matrix));
            //输出测试
//            for (int[] ints : matrix) {
//                for (int anInt : ints) {
//                    System.out.print(anInt+"\t");
//                }
//                System.out.println();
//            }
        }
    }
    //转换成稀疏数组
    public static int[][] toSparseArray(int[][] matrix){
        int count = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int[] row : matrix) {
            for (int col : row) {
                if (col != 0) count++;
            }
        }
        //初始化第一行【行数、列数、非零个数】
        int[][] sparseArray = new int[count+1][3];
        sparseArray[0][0] = rows;
        sparseArray[0][1] = cols;
        sparseArray[0][2] = count;

        int index = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0){
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = matrix[i][j];
                    index++;
                }
            }
        }

        return sparseArray;
    }

    public static void printArray(int[][] array){
        for (int[] row : array) {
            for (int data : row) {
                System.out.print(data+"\t");
            }
            System.out.println();
        }
    }
}
