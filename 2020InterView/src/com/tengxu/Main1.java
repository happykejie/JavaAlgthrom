package com.tengxu;

import java.util.*;
import java.math.*;

/**
 * 滑动窗口题型——求窗口内和最小值，
 *
 * 园丁拔出K个栅栏，每个栅栏高度一样， 要拔出K个连续的最小高度的栅栏。
 * 输入：第一行 7 3 表示总共7栏， K为3个
 * 第二行： 1 2 6 1 1 7 1 表示7个栏高度。
 * */
public class Main1 {
    public  static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int n= 0;
        int k =0;
        List<Integer> arrh = new ArrayList<Integer>();
        if(sc.hasNextInt())
        {
            n = sc.nextInt();
            k = sc.nextInt();
        }
        HashMap<Integer, Integer> lhmap = new HashMap<>();
        //所有栅栏存入数组
        int[] shanlanarr = new int[n];
        for(int i=0; i<n;i++)
        {
            int hi = sc.nextInt();
            shanlanarr[i]=hi;
        }
        int curminlength =0;
        int start =0;
        // 定义一个双向队列来保持窗口内和的最小值区域
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<shanlanarr.length;i++)
        {
            if (i<k){ //初始化第一个窗口和
                curminlength +=shanlanarr[i];
            }
            else {
                int nexttotal = curminlength-shanlanarr[i-k]+shanlanarr[i];
                if(nexttotal<curminlength){
                    curminlength =nexttotal;
                    start =i-k+2;
                }
            }
        }

        System.out.println("开始拔位置："+start+",最小长度："+curminlength);

        //排序
    }

    //求数组中的最大值
    public static int arrSum(int arr[]) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
        }
        return temp;
    }
    public static int arrMax(int arr[]) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (temp < arr[i])
                temp = arr[i];
        }
        return temp;
    }
    public static int arrMin(int arr[]) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (temp > arr[i])
                temp = arr[i];
        }
        return temp;
    }
}
