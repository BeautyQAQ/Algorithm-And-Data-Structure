package org.example.leetCode;

import java.util.ArrayList;
import java.util.HashMap;

import org.example.common.Node;

/**
 * No.133 克隆图
 */
public class CloneGraph {
    public static Node cloneGraph(Node node) {
        return clone(node, new HashMap<Integer, Node>());
    }

    private static Node clone(Node node, HashMap<Integer, Node> visited) {
        // 边界条件判断,这种情况只有头节点会出现
        if (node==null) {
            return null;
        }
        // 当前节点已经被访问过,则直接返回
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        // 否则创建当前节点
        Node newNode = new Node(node.val, new ArrayList<>());
        // 将创建好的节点存入map
        visited.put(newNode.val, newNode);
        // 创建当前节点的邻居节点
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor, visited));
        }
        return newNode;
    }
}