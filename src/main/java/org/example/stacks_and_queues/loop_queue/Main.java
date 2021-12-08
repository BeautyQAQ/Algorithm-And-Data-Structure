package org.example.stacks_and_queues.loop_queue;

import java.util.Random;

/**
 * 用时测试
 */
public class Main {

    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random(1000);
        for(int i = 0 ; i < opCount ; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
        /**
         * ArrayQueue, time: 34.204913278 s
         * LoopQueue, time: 0.013744074 s
         * 数组队列这么慢是因为: 数组队列的enqueue操作是O(1)，dequeue操作是O(n), 每次enqueue都要移动数组元素，而环形队列则没有这个问题
         */
    }
}
