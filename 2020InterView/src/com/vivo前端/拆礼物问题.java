package com.vivo前端;

import java.util.*;
import java.util.Scanner;

/**
 * （（（（）（）（0）））） ， 最快找到0的位置
 * */
public class 拆礼物问题 {

    public  static  void  main(String[] args){

        Scanner sc = new Scanner(System.in);
        String str = "( ( )(() ( ( () (0)))))";

        int result =0;
        char[] strarr = str.toCharArray();
        ArrayList<Integer>  intarr = new ArrayList<>();
        for(int i =0; i<str.length();i++){

            if(str.charAt(i)=='(' || str.charAt(i)=='0' ||str.charAt(i) ==')'){

                if(str.charAt(i)=='('){
                    intarr.add(1);
                }
                if(str.charAt(i)==')'){
                    intarr.add(2);

                }
                if(str.charAt(i)=='0'){
                    intarr.add(0);
                }
            }
        }


        int totallength = intarr.size();
        int mid = totallength/2;
        int index =0;
        for(int i=0; i<intarr.size();i++){
            if(intarr.get(i)==0){
                index =i;
            }
        }
        if(index>mid){
            result = totallength-1 - index;
        }
        else {
            result = index;
        }

        System.out.println(result);
    }

}
