package com.bytedance;

import java.util.Scanner;

import  java.util.*;
import  java.math.*;
public class Main1 {
    public  static  void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> map = new HashMap<>();
        int clicknum =0;
        int reachtime = 0;

        if(sc.hasNextInt())
        {
            clicknum = sc.nextInt();
        }
        for(int i=1; i<=clicknum;i++)
        {

            Integer s1 = sc.nextInt();
            Integer s2 = sc.nextInt();
            map.put(s1, s2);

        }
        reachtime = sc.nextInt();

        int M = sc.nextInt();
        String[] strArr = new String[M];
        int[] intarr = {10,3,6,1,4,5,9};
        Arrays.sort(intarr);

        if(sc.hasNextInt())
        {
//            for(int i=0; i<N;i++)
//            {
//
//            }
        }

        System.out.println("test");
    }
}
