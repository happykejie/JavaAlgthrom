package com.tengxu;

import java.util.*;
import java.math.*;
import java.util.Scanner;
public class Main3 {
    public  static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n= 0;
        int m =0;
        List<Integer> arrh = new ArrayList<Integer>();
        if(sc.hasNextInt())
        {
            n = sc.nextInt();
            m = sc.nextInt();
        }

        List<Integer> WI = new ArrayList<Integer>();
        List<Integer> VI = new ArrayList<Integer>();

        for(int i=0; i<n;i++)
        {
            int wi = sc.nextInt();
            WI.add(wi);
        }
        for(int i=0; i<n;i++)
        {
            int vi = sc.nextInt();
            VI.add(vi);
        }
        int min =0;
        int start =0;
        int[] threemin = new int[3];
        for(int i=0; i<arrh.size();i++)
        {
        }
        //排序
    }

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
