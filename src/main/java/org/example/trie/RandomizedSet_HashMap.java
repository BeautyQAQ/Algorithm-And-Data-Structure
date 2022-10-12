package org.example.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 使用Java内置的HashMap，作为算法实现的基准
 */
public class RandomizedSet_HashMap {
    HashMap<String, Integer> map;
    ArrayList<Integer> numbs;

    public RandomizedSet_HashMap() {
        map = new HashMap();
        numbs = new ArrayList<>();
    }

    public boolean insert(int val) {
        String key = Integer.toString(val);
        if (map.containsKey(key)) {
            return false;
        }
        numbs.add(val);
        int index = numbs.size() - 1;
        map.put(key, index);
        return true;
    }

    public boolean remove(int val){
        String key = Integer.toString(val);
        if (!map.containsKey(key)) {
            return false;
        }
        int index = map.get(key);
        map.remove(key);
        int num = numbs.get(numbs.size()-1);
        numbs.remove(numbs.size() -1);
        if (num != val) {
            numbs.set(index, num);
            map.put(Integer.toString(num), index);
        }
        return true;
    }

    public int getRandom(){
        Random random = new Random();
        int index = random.nextInt(numbs.size());
        return numbs.get(index);
    }

    public static void main(String[] args) {
        RandomizedSet_HashMap rs = new RandomizedSet_HashMap();
        rs.insert(0);
        rs.remove(0);
        rs.insert(-1);
        rs.remove(0);
    }
}
