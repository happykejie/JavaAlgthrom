package com.tengxu2;
import  java.util.*;

/**
 * 换钱思想
 *
* */
public class Main5 {

    public  static  void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = 0;
        int k =0;
        n = sc.nextInt();
        k = sc.nextInt();
        int[][] arr = new int[3][2];

        for(int i=0; i<arr.length;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for(int j =0; j<arr.length;j++){
            int left = arr[j][0];
            int right = arr[j][1];

            int totalnums = 0;

            ArrayList<Integer> list = new ArrayList<>();

            list.add(1); //表示红花
            list.add(k); //表示1倍
            int kb = k;
            while (kb<=right){
                kb =kb*kb;
                if(kb<=right)
                {
                    list.add(kb);
                }
            }

            int[] kbarr = new int[list.size()];
            for(int i=0; i<list.size();i++){
                int item = list.get(i);
                kbarr[i] =item;
            }

            //从大开始换算
            while (right>=left){
                totalnums += countWays(kbarr,kbarr.length,right);
                totalnums += countWays2(kbarr,kbarr.length,right);
                right --;

            }




            System.out.println(totalnums);


        }



    }

    public static int countWays(int[] penny, int n, int aim) {
        // write code here
        int[] dp = new int[aim + 1];
        for (int i = 0; i < aim + 1; i++) {
            if (i % penny[0] == 0){
                dp[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < aim + 1; j++) {
                if (j >= penny[i]) {
                    dp[j] += dp[j - penny[i]];
                }
            }
        }
        return dp[aim];
    }

    ///重复值
    public static int countWays2(int[] penny, int n, int aim) {
        // write code here
        int ewnum =0;
       for(int i =1; i<penny.length;i++) {

           int item = penny[i];
           if (aim > item)
           {
               ewnum += (aim/item);
           }
       }
       return  ewnum;
    }


}
