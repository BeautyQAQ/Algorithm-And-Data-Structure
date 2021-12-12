package org.example.stacks_and_queues.stack;

/**
 * 栈, 先进后出
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
