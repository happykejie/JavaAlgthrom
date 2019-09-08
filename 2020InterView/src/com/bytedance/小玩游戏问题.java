package com.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 小玩游戏问题 {

    public  static  void  main(String[] args){

        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt(); //代表方块数量
//        int m = sc.nextInt(); //方块上的数组最大不超过M
//        int q = sc.nextInt(); //小Q玩了几次游戏
//        String str = sc.nextLine();

        int n=4;
        int m =10;
        int q =6;
        String str =">22<";

        char[] strarr = str.toCharArray();

        int lenghth = strarr.length;
        ArrayList<Integer>  fkint = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();

        for(int i =0; i<strarr.length;i++){
            char c = strarr[i];
            if(c =='<'){
                //表示向左边
               hm.put(i,-1);
               continue;
            }
            else if(c =='>'){
                //表示向右边
                hm.put(i,-2);
                continue;
            }
            else {
                int num = Integer.parseInt(String.valueOf(c));
                hm.put(i,num);
            }
        }

//        int[][] zcarr = new int[q][2];
//
//        for(int i =0; i<zcarr.length;i++){
//            zcarr[i][0] =sc.nextInt();
//            zcarr[i][1] =sc.nextInt();
//        }

        int[][] zcarr ={{1,4},{1,3},{2,4},{2,3},{1,1},{2,2}};


        for(int i =0; i< zcarr.length;i++){
            int result = countMax(zcarr[i][0],zcarr[i][1],hm);
            System.out.println(result);
        }

    }

    /**
     *
     */
    public  static  int  countMax(int L, int R, HashMap<Integer,Integer> hm){
        int Lbj = L-1;
        int Rbj = R-1;
        int startindex = L;

        int total =0;
        int curfx =-2;
        int preblockvalue = 0;
        while (startindex != Lbj || startindex != Rbj){
            int curblockvalue = hm.get(startindex);

            if(curblockvalue ==preblockvalue ||curblockvalue ==preblockvalue){ //表示下一个也是方位符号
                hm.put(startindex,-3); //销毁这个块
                if(curfx==-2){
                    startindex ++;
                    continue;

                }
                else {
                    startindex --;
                    continue;

                }
            }

            if(curblockvalue==-1){ //向左边
                total +=0;
                startindex--;
                curfx=-1;
                continue;

            }
            if(curblockvalue==-2){ //向右边
                total +=0;
                startindex++;
                curfx=-2;
                continue;

            }



            if(curblockvalue == 0){
                total +=0;
                hm.put(startindex,-3); //销毁这个块
                if(curfx ==-2){
                    startindex ++;
                }
                else {
                    startindex --;
                }

            }

            else { //其它数字获取值，并减一更新

                int value = hm.get(startindex);
                total += value;
                hm.put(startindex,value-1);
                if(curfx ==-2){
                    startindex ++;
                }
                else {
                    startindex --;
                }

            }

        }


        return  total;
    }
}
