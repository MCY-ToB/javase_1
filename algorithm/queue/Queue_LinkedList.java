package algorithm.queue;

public class Queue_LinkedList {
    public static void main(String[] args) {
        Queue_ queue = new Queue_(5);
        queue.push(new Node(1));
        queue.push(new Node(2));
        queue.push(new Node(3));
        queue.push(new Node(4));
        queue.push(new Node(5));
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.push(new Node(6));
        queue.push(new Node(7));
        queue.push(new Node(8));
        queue.print();
    }
}

class Queue_{
    Node head;
    int maxSize,size;

    public Queue_() {
        this.head = new Node(-1);
        this.maxSize = 10;
        this.size = 0;
    }

    public Queue_(int maxSize) {
        this.head = new Node(-1);
        this.maxSize = maxSize;
        this.size = 0;
    }
    //判断队列是否已满
    public boolean isFulled(){
        return size == maxSize;
    }
    //判断是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //添加push
    public void push(Node node){
        if (node == null) return;
        if (isFulled()){
            System.out.println("队列已满，添加["+node.value+"]失败");
        }else {
            //辅助节点
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
            size++;
        }
    }
    //删除元素pop
    public void pop(){
        if (isEmpty()){
            System.out.println("队列为空，删除失败");
        }else{
            head.next = head.next.next;
            size--;
        }
    }
    //打印队列print
    public void print(){
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
            System.out.print(temp.value+"--->");
        }
    }
}

class Node{
    int value;
    Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
