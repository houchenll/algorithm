package com.hc.algorithm.main.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class P56MergeIntervals {

    /**
     * 第1步，按区间左端点从小到大排序
     * 第2步，遍历所有区间，合并。如果当前区间左端点大于最后一个已合并区间右端点，则本区间与前面区间无法合并，另起
     * 6ms > 90%
     * 时间复杂度：O(N logN)，排序需N logN时间，之后只需一次遍历
     * 空间复杂度：O(logN)，排序所需空间复杂度
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            // 0行2列
            return new int[0][2];
        }
        // 按区间左端点从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 存储所有已合并区间
        List<int[]> mergedList = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            if (mergedList.size() == 0 || l > mergedList.get(mergedList.size() - 1)[1]) {
                mergedList.add(interval);
            } else {
                // 更新最后一个合并区间的右边界
                mergedList.get(mergedList.size() - 1)[1] = Math.max(mergedList.get(mergedList.size() - 1)[1], r);
            }
        }
        // toArray时，需指定有多少行
        return mergedList.toArray(new int[mergedList.size()][]);
    }

}
