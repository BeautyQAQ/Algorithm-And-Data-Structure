package org.example.linked_list;

import java.util.Random;

import org.example.stacks_and_queues.stack.ArrayStack;
import org.example.stacks_and_queues.stack.Stack;

/**
 * 用时比较测试
 */
public class Main {

    // 测试使用q运行opCount个push和pop操作所需要的时间，单位：秒
    private static double testStack(Stack<Integer> stack, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random(1000);
        for(int i = 0 ; i < opCount ; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");
        /**
         * ArrayStack, time: 0.0132003 s
         * LinkedListStack, time: 0.0163173 s
         * LinkedListStack不一定就比ArrayStack慢快: 
         * ArrayStack慢的地方在于扩容和缩容, 复制数组中的元素
         * LinkedListStack慢的地方在于创建Node这个对象, 需要在内存中寻找可以开辟的空间
         */
    }
}
