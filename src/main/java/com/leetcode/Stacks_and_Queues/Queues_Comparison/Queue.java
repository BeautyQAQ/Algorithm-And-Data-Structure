package com.leetcode.Stacks_and_Queues.Queues_Comparison;

/**
 * 队列
 * @param <E> 泛型
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
