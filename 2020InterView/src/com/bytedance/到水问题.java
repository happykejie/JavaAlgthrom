package com.bytedance;

import java.util.Scanner;

public class 到水问题 {

    public  static  void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int K = sc.nextInt();
        int res =0;
        if(K==A|| K==B ||K ==C){
            res =1;
        }


        System.out.println(res);

    }
}
