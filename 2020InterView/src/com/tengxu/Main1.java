package com.tengxu;

import java.util.*;
import java.math.*;
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

        for(int i=0; i<n;i++)
        {
            int hi = sc.nextInt();
            lhmap.put(i,hi);
            arrh.add(hi);
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
