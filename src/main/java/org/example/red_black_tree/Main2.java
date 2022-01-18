package org.example.red_black_tree;

import java.util.ArrayList;
import java.util.Random;

import org.example.avl_tree.AVLTree;
import org.example.map.BSTMap;

public class Main2 {
    public static void main(String[] args) {

        // int n = 20000000;
        int n = 20000000;

        Random random = new Random(n);
        ArrayList<Integer> testData = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            testData.add(random.nextInt(Integer.MAX_VALUE));

        // Test BST
        long startTime = System.nanoTime();

        BSTMap<Integer, Integer> bst = new BSTMap<>();
        for (Integer x : testData)
            bst.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST: " + time + " s");

        // Test AVL
        startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x : testData)
            avl.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");

        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x : testData)
            rbt.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");
    }

    // BST: 71.578111218 s
    // AVL: 90.43537007 s
    // RBTree: 99.041874535 s
}
