package org.example.segment_tree;

/**
 * 线段树
 */
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;

    private Merger<E> merger;

    @SuppressWarnings("unchecked")
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        // 开辟4*n的空间肯定足够
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l...r]的线段树
     * 
     * @param treeIndex 线段树创建位置
     * @param l         区间l
     * @param r         区间r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // int mid = (1 + r) / 2;
        int mid = l + (r - l) / 2;
        // 递归调用build左右两个子树的结构
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        // 融合左右子树的值
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal. ");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * 
     * @param 查找索引
     * @return 左孩子索引
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * 
     * @param 查找索引
     * @return 右孩子索引
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 返回区间[queryL, queryR]的值
     * @param queryL 左边界
     * @param queryR 有边界
     * @return 返回区间[queryL, queryR]的值
     */
    public E query(int queryL, int queryR){
        if (queryL<0 || queryR>= data.length || queryR<0 || queryR>= data.length || queryL> queryR) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0, 0, data.length-1, queryL, queryR);
    }

    /**
     * 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
     * @param treeIndex 根
     * @param l 范围
     * @param r 范围
     * @param queryL 查询区间
     * @param queryR 查询区间
     * @return 区间[queryL...queryR]的值
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r-l)/2;
        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid+1) {
            return query(rightTreeIndex, mid+1, r, queryL, queryR);
        } else if (queryR <= mid){
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        // 到这里, 说明查询的区间[queryL, queryR]分布在线段树的两边
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(treeIndex, mid+1, r, mid+1, queryR);
        return merger.merger(leftResult, rightResult);
    }

    /**
     * 将index位置的值, 更新为e
     * @param index 位置
     * @param e 新的值
     */
    public void set(int index, E e){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 在以treeIndex为根的线段树中更新index的值为e
     * @param treeIndex 根节点
     * @param l 区间
     * @param r 区间
     * @param index 位置
     * @param e 新的值
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        // 递归结束
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r-l)/2;
        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index>=mid+1) {
            set(rightTreeIndex, mid+1, r, index, e);
        } else {
            set(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            }else{
                res.append("null");
            }

            if(i != tree.length - 1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        Integer[] numbs = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(numbs,(a, b) -> a + b);
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));
    }
}
