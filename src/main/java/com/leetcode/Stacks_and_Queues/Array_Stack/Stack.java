package com.leetcode.Stacks_and_Queues.Array_Stack;

/**
 * 栈
 * @param <E> 泛型
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
