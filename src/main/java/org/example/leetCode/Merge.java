package org.example.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * No.56 合并区间
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0) {
            return intervals;
        }
        // 将数组按照第一维的值排序,升序
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        ArrayList<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R=intervals[i][1];
            // List中的最大值小于L,则将L添加进List
            if (merged.size()==0 || merged.get(merged.size()-1)[1] < L) {
                merged.add(new int[]{L,R});
            } else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
