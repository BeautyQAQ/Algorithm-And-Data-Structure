package org.example.leetcode.queue_stack;

/**
 * 循环队列--我的实现
 * 这个实现方案的特点是, data的大小是比传入的k要+1
 */
public class MyCircularQueue {
    private int[] data;
    private int front;
    private int rear;
    public MyCircularQueue(int k) {
        data = new int[k+1];
        front = 0;
        rear = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        // 入队只要考虑rear节点
        data[rear]=value;
        rear=(rear+1)%data.length;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        // 出队只要考虑front节点
        front=(front+1)%data.length;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[(rear - 1 + data.length) % data.length];
    }
    
    public boolean isEmpty() {
        return rear==front;
    }
    
    public boolean isFull() {
        return (rear+1)%data.length==front;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(5);
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.enQueue(5);
        boolean enQueue = obj.enQueue(6);
        System.out.println(enQueue);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */