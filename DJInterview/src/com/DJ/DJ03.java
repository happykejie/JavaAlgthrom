package com.DJ;

import java.util.Scanner;

public class DJ03 {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); //买零食的开销
        int N = sc.nextInt(); //买零食的种类
        Integer[] arrtype = new Integer[N];
        for (int i = 0; i < N; i++) {
            int s1 = sc.nextInt();
            arrtype[i] = s1;
        }

        //特别喜欢的零食
        Integer[] lovetype = new Integer[N];
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int s1 = sc.nextInt();
            lovetype[i] = s1;
        }




        System.out.println(lovetype[0]);
    }
}
