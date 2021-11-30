package org.example.Stacks_and_Queues.More_about_Leetcode;

/**
 * 栈
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
