package com.iqiyi;

import java.util.Scanner;

public class 排列计数问题 {



        public static void main(String[] args) {

            Scanner sc  = new Scanner(System.in);
            int N  = sc.nextInt();

            int[] check = new int[N];

            for(int i=0; i<N; i++)
            {
                check[i] =sc.nextInt();
            }

            //构造全排数组
            int[] arr = new int[N];
            for(int i=0; i<N; i++)
            {
                arr[i] =i+1;
            }

            fullSort(arr, 0, arr.length - 1,check);
            System.out.println(res);
        }

        static int res = 0;

        static void fullSort(int[] arr, int start, int end, int[] check) {
            // 递归终止条件
            if (start == end) {
                // 求出了全排列的一种情况，然后检查是否满足条件
                if (check(arr,check))
                    res++;
                return;
            }
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                fullSort(arr, start + 1, end,check);
                swap(arr, start, i);
            }
        }

        private static void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        public  static boolean check(int[] arr,int[] check) {
            for (int i = 1; i < arr.length-1; i++) {
                if (check[i] == 0) {
                    if (arr[i] > arr[i + 1]) {
                        return false;
                    }
                }

                if (check[i] == 1) {
                    if (arr[i] < arr[i + 1]) {
                        return false;
                    }
                }
            }
            return true;

        }

}
