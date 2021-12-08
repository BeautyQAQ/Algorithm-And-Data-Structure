package org.example.stacks_and_queues.loop_queue;

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
