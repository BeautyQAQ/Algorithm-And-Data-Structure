package org.example.Stacks_and_Queues.Loop_Queue;

/**
 * 队列, 先进先出
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
