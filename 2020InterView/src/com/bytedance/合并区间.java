package com.bytedance;
import  java.util.*;
public class 合并区间 {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        // 输入为空
        if (intervals == null || intervals.size() < 1) {
            return result;
        }
        int len = intervals.size();
        int[] starts = new int[len];
        int[] ends = new int[len];
        //将首尾整数分别放置在两个数组中
        for (int i = 0; i < len; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        // 对两个数组进行排序
        Arrays.sort(starts);
        Arrays.sort(ends);
        // 合并重叠区间
        for (int i=0,j=0; i < len; i++) {
            if(i == len - 1 || starts[i + 1] > ends[i]) {
                result.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return result;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        // 数据长度未达到合并操作要求
        if (intervals.length < 2)
            return intervals;
        //按二维数组第一位排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        //合并区间，若区间不能合则前者加入list中
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] <= intervals[i][1]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }
        //最后的区间加入list中
        list.add(intervals[intervals.length - 1]);
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
}

}
