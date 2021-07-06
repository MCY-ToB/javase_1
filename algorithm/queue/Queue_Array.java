package algorithm.queue;

import java.util.Arrays;

public class Queue_Array {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.push(33);
        queue.push(44);
        queue.push(99);
        queue.push(99);
        queue.push(99);
        queue.push(99);
        queue.pop();
        queue.pop();
        queue.push(99);
        queue.push(99);
        queue.push(11);
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        System.out.println("queue.size() = " + queue.size());
        queue.push(1);
        queue.print();
    }
}

//队列
class Queue{
    int[] queue;
    int front,rear,maxSize;
    public Queue(){
        queue = new int[10];
        front = 0;
        rear = 0;
        maxSize = 10;
    }
    public Queue(int maxSize){
        queue = new int[maxSize];
        front = 0;
        rear = 0;
        this.maxSize = maxSize;
    }
    //获取元素个数
    public int size(){
        return (rear - front + maxSize) % maxSize;
    }
    //遍历输出队列元素
    public void print(){
//        System.out.println("队列元素："+ Arrays.toString(queue));
        System.out.print("队列元素："+"[\t");
        for (int i = front; i < front+size(); i++) {
            System.out.printf("%d\t", queue[front%maxSize]);
        }
        System.out.print("]");
    }
    //判断队列是否已满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加元素push方法
    public void push(int element){
        //判断队列是否已满
        if (isFull()){
            //已满则输出队列已满
            System.out.println("队列已满，添加失败。");
        }else{
            //未满则添加
            queue[rear] = element;
            rear = (rear + 1 + maxSize) % maxSize;
            System.out.println(element+"--->添加成功！");
        }
    }
    //删除元素pop方法
    public void pop(){
        if (isEmpty()){
            System.out.println("队列为空，删除失败！");
        }else {
            int element = queue[front];
            front = (front + 1 + maxSize) % maxSize;
            System.out.println("删除元素；"+element);
        }
    }
}
