package org.example.segment_tree;

public interface Merger<E> {
    E merger(E a, E b);
}
