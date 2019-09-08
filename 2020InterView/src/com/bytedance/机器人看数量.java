package com.bytedance;

import java.util.Scanner;

/*
* 测试通过27%
* */

public class 机器人看数量 {


    public  static  void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        int[] countnum  = new int[N];
        countnum[N-1]=0;//最后一个肯定没有人能看到

        for(int i=0; i<arr.length;i++){

            arr[i]= sc.nextInt();
        }

        for(int i=0; i<arr.length-1; i++){
            int count =1;
            int curH = arr[i];
            int next= arr[i+1];
            if(next<=curH){
                countnum[i] =count++;
            }
            else {
                countnum[i]=0;
            }
            for(int j=i+2;j<arr.length;j++){

                int temp = arr[j];
                if(temp>=next &&temp<=curH)
                {
                    countnum[i]=count++;
                }

            }
        }
        //查询最大值所以
        int max =0;
        int maxindex =0;
        for(int i=0; i<countnum.length;i++){
            if(countnum[i]>max){
                max= countnum[i];
                maxindex =i;
            }

        }

        System.out.println(arr[maxindex]);
    }
}
