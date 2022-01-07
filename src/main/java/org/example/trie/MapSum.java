package org.example.trie;

import java.util.TreeMap;

/**
 * 词频统计
 */
public class MapSum {
    private class Node{

        public int value;
        public TreeMap<Character, Node> next;

        public Node(int value){
            this.value = value;
            next = new TreeMap<>();
        }

        public Node(){
            this(0);
        }
    }

    private Node root;

    public MapSum(){
        root = new Node();
    }

    public void insert(String key, int val){
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c)==null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }
}
