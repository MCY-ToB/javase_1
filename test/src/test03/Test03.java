package test03;

import java.util.*;

public class Test03 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
//        tree.preOrder();
        tree.fixOrder();
    }
}

class ArrayBinaryTree{
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载
    public void preOrder(){
        preOrder(0);
    }

    //前序遍历
    public void preOrder(int index){
        if (arr == null || arr.length == 0) {
            System.out.println("该数组为空");
            return;
        }
        System.out.println(arr[index]);
        if ((index * 2 + 1) < arr.length){
            preOrder(index*2+1);
        }
        if ((index * 2 + 2) < arr.length){
            preOrder(index*2+2);
        }
    }

    public void fixOrder(){
        fixOrder(0);
    }

    //中序遍历
    public void fixOrder(int index){
        if (arr == null || arr.length == 0) {
            System.out.println("该数组为空");
            return;
        }

        if ((index * 2 + 1) < arr.length){
            fixOrder(index*2+1);
        }
        System.out.println(arr[index]);
        if ((index * 2 + 2) < arr.length){
            fixOrder(index*2+2);
        }
    }
}


