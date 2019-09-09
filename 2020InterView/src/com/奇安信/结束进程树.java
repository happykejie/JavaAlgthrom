package com.奇安信;

import java.util.ArrayList;
import java.util.Scanner;

public class 结束进程树 {

    public  static  void main(String[] args){

        Scanner sc =new Scanner(System.in);
        String strpid = "3 1 5 21 10 11 12 13 14 15 16 17";
        String[] strpidarr = strpid.split(" ");
        String strppid = "0 3 3 1 5 5 5 5 5 5 5 5";
        String[] strppidarr = strppid.split(" ");

        int target = 5;
        ArrayList<Integer> childs = new ArrayList<>();
        ArrayList<Integer> curlevels = new ArrayList<>();
        curlevels.add(target);
        childs.add(target);
        boolean ischild =true;
        findchilds(strppidarr,curlevels,childs,ischild);


        System.out.println(childs.size());




    }

    public  static  void  findchilds(String[] strppidarr,  ArrayList<Integer>  curlevels,ArrayList<Integer> childs,boolean ischild){

        ArrayList<Integer> templevels = new ArrayList<>();
        if(!ischild){
            return;
        }
        ischild = false;
        for(int j=0; j<curlevels.size(); j++){
            int target = curlevels.get(j);
            for(int i =0; i<strppidarr.length; i++){
                int temp = Integer.parseInt(strppidarr[i]);
                if(target==temp){
                    templevels.add(i);
                    childs.add(i);
                    ischild =true;
                }
            }
        }

        findchilds(strppidarr,templevels,childs,ischild);

    }
}
