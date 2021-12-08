package org.example.stacks_and_queues.loop_queue;

/**
 * 环形队列
 * 可以思考一下：
 * LoopQueue中不声明size，如何完成所有的逻辑？
 * 这个问题可能会比较难
 * 
 * 不管是出队还是入队, 头指针和尾指针都向同一方向移动(比如右边)
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    // 需要对容量+1, 因为有一个容量被浪费了
    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    // 当头指针等于尾指针时, 队列为空, 这种实现方式会有一个容量被浪费
    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    @Override
    public int getSize(){
        return size;
    }

    // 入队
    @Override
    public void enqueue(E e){
        // 当队尾指针+1和数组长度取模等于队首指针时, 数组容量占满, 需要扩容
        if((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        /**
         * 取模操作, 保证队列的环形状态
         * 如果tail + 1 == data.length, 则tail = 0
         * 例: 假设tail = 5, data.length = 10, 则tail + 1 = 6, 取模后为6
         *     如果tail == 9, 则tail + 1 = 10, 取模后为0
         */
        tail = (tail + 1) % data.length;
        size ++;
    }

    // 出队
    @Override
    public E dequeue(){

        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        /**
         * 例: 假设 data.length = 10, front = 9
         *     (9 + 1) % 10 = 0 
         */
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    // 扩容, 需要对容量+1, 因为有一个容量被浪费了
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        /**
         * 拷贝数组, 让新的数组的元素位置重新从索引0开始
         * (i + front) % data.length, 是front指针向右移动
         */
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[(i + front) % data.length];

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
