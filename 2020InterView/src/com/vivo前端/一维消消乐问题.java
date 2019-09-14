package com.vivo前端;

import java.util.*;

/**
 *消除相同颜色的， K>=0 ,积分为K*K个积分
 * */
public class 一维消消乐问题 {

     public  static  void  main(String[] args){

         Scanner sc = new Scanner(System.in);
         String str ="1 4 2 2 3 3 2 4 1";
         String[]  strarr = str.split(" ");
         int n = strarr.length;
         int[]  intarr = new int[n];
         for(int i =0; i<strarr.length;i++){
             intarr[i] = Integer.valueOf(strarr[i]);
         }



     }

}
