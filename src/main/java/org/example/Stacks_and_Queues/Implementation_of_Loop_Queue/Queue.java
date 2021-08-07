package org.example.Stacks_and_Queues.Implementation_of_Loop_Queue;

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
