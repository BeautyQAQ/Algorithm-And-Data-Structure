package org.example.arrays;

/**
 * 数据结构--数组
 * @param <E> 泛型
 */
public class Array<E> {
    private E[] data;
    private int size;
    /**
     * 构造函数,传入数组的容量
     * @param capacity 数组容量
     */
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }
    /**
     * 无参构造函数,默认容量capacity = 10
     */
    public Array() {
        this(10);
    }
    /**
     * 数组构造函数
     * @param arr 数组
     */
    @SuppressWarnings("unchecked")
    public Array(E[] arr) {
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }
    /**
     * 获取数组中元素的个数
     */
    public int getSize() {
        return size;
    }
    /**
     * 获取数组的容量
     */
    public int getCapacity() {
        return data.length;
    }
    /**
     * 返回数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 向所有元素后添加一个元素
     * @param e 需要添加的元素
     */
    public void addLast(E e){
        add(size, e);
    }
    /**
     * 在所有元素前添加一个元素
     * @param e 需要添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }
    /**
     * 在index处加入一个新元素e
     * @param index 插入位置
     * @param e 插入元素
     */
    public void add(int index, E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if(size == data.length) {
            resize(2 * data.length);
        }
        for(int i = size - 1; i >= index; i --) {
            data[i + 1] = data [i];
        }
        data[index] = e;
        size++;
    }
    /**
     * 获取index索引位置的元素
     * @param index 索引位置
     * @return 结果元素
     */
    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }
    /**
     * 修改index索引位置的元素为e
     * @param index 索引位置
     * @param e 修改数据
     */
    public void set(int index, E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }
    /**
     * 查找数组中是否有元素e
     * @param e 元素
     * @return 是否存在
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 查找数组中元素e所在的索引,如果不存在元素e,则返回负一
     * @param e 查找元素
     * @return 返回元素索引
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * 删除数组中索引index的元素
     * @param index 删除元素的索引
     * @return 被删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null; // loitering objects != memory leak  空闲对象 != 内存泄漏
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }
    /**
     * 删除数组中第一个元素
     * @return 被删除的元素
     */
    public E removeFirst(){
        return remove(0);
    }
    /**
     * 删除数组中最后一个元素
     * @return 被删除的元素
     */
    public E removeLast(){
        return remove(size-1);
    }
    /**
     * 从数组中删除元素e
     * @param e 要删除的元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 交换两个位置的元素
     * @param i 位置
     * @param j 位置
     */
    public void swap(int i, int j) {
        if(i < 0 || i >= size || j < 0 || j >= size){
            throw new IllegalArgumentException("Index is illegal.");
        }
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    /**
     * 重写toString方法
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size,data.length));
        res.append('[');
        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
    /**
     * 将数组空间的容量变成newData大小
     * @param newCapacity 新的容量大小
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}