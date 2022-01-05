package org.example.segment_tree;

/**
 * 融合器
 * 可以求和, 求最大值, 求最小值, 根据业务实现
 */
public interface Merger<E> {
    E merger(E a, E b);
}
