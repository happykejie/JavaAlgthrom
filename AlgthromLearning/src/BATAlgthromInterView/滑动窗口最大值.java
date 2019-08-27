package BATAlgthromInterView;

import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口最大值 {

    public  static  void  main(String[] args){
        int[] arr = {4,3,5,4,3,3,6,7};
        int w=3;
        slide(arr,3);
    }

    //实现滑动窗口获取每个窗口最大值
    public  static  int[] slide(int[] arr,int w){
        int[] res = new int[arr.length - w + 1];
        if (arr == null || w > arr.length) {
            return res;
        }
        //Deque 是双端队列， 和Queue 差不多
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            // 尾部删除元素
            if (!deque.isEmpty() && deque.peekLast() <= i - w) {
                deque.pollLast();
            }
            // 头部删除元素
            while (!deque.isEmpty() && arr[deque.peekFirst()] < arr[i]) {
                deque.pollFirst();
            }
            // 头部添加元素, 只添加更大的元素
            if (deque.isEmpty() || arr[deque.peekFirst()] >= arr[i]) {
                deque.offerFirst(i);
            }
            //
            if (i >= w - 1) {
                res[i - w + 1] = arr[deque.peekLast()];
            }
        }
        return res;

    }



}


