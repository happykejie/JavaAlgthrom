package com.baidu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public  static  void  main(String[] args){

        Scanner sc = new Scanner(System.in);

        String str = "( () ( () ( （ () (0) ) ) ) )";

        char[] arr = str.toCharArray();
        int j =0;
        ArrayList<Integer>  intarr = new ArrayList<>();
        for(int i =0; i<arr.length;i++){

            if(arr[i]=='(' || arr[i]=='0' ||arr[i] ==')'){

                if(arr[i]=='('){
                    intarr.add(1);
                }
                if(arr[i]==')'){
                    intarr.add(2);

                }
                if(arr[i]=='0'){
                    intarr.add(0);
                }
            }
        }
    }
}
