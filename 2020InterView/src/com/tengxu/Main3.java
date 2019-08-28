package com.tengxu;

import java.util.*;
import java.math.*;

/**
 * 冰淇淋问题，每个冰淇淋 n 种配料，每个配料 wi 份，钱数 m , 每个配料售价 vi 元。 问：使用现有配料和钱最多可以做多少分冰淇淋
 * */
import java.util.Scanner;
public class Main3 {
    public  static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=0;
        int m =0;
        if(sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
        }
        //获取每种配料的存储数量
        int[] warr = new int[n];
        for(int i=0; i<n;i++){
            warr[i] = sc.nextInt();
        }

        //每个配料的售价
        int[] wparr = new int[n];
        for(int i=0; i<n;i++){
            wparr[i] = sc.nextInt();
        }
        //利用有序表实现-由于不能存放相同元素，放弃这个方案
//        TreeMap<Integer,Integer> wptree = new TreeMap<>();

        //由于配出多少冰淇淋是由木桶原理最小的一个短板决定的。

        int pmin =wparr[0]; //设置售价初始最小值
        for (int i =0; i<wparr.length;i++) {
            if (wparr[i] < pmin) {
                pmin = wparr[i];
            }
        }

        // 如果剩余钱，小于最小的售价，怎么结束
        int restm = m;
        int minw = 0;
        while (restm>=pmin){

            //循环一边，查找最小的存货类型，进行购买1分
            int curindex =0; // 当前最小值存货索引
            int min = warr[0]; // 用于记录数组最小值，初始值可以是数组中的任意一个值或者是Integer.MAX_VALUE
            for (int i =0; i<warr.length;i++) {
                if (warr[i] < min) {
                    min = warr[i];
                    minw =warr[i];
                    curindex = i;
                }
            }

            //购买了最小值对于价格一份，金额减去花费
            restm -= wparr[curindex];

            if(restm<pmin){
                break;
            }

            //修改原来最小值，增加1分
            warr[curindex] =warr[curindex]+1;
        }
        System.out.println("最多能制造冰淇淋个数为："+minw);


    }




}
