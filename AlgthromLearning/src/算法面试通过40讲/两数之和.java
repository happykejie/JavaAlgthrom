package 算法面试通过40讲;

import  java.util.*;
public class 两数之和 {


    public  static  void  main(String[] args){

        int[] nums ={2,7,11,15};
        int target =9;

        int[] resarr = new int[2];

        int x =0;
        int y =0;
        y = target-x;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){

            hm.put(nums[i],i);
        }

        for(int j=0; j<nums.length;j++){

            int cur = nums[j];
            boolean isexit = hm.containsKey(target-cur);

            if(isexit){

                int key = target-cur;
                int r = hm.get(key);

                if(j !=r){
                    resarr[0]=j;
                    resarr[1]=r;
                    break;
                }


            }


        }

        System.out.println(resarr[0]+","+resarr[1]);
    }




}
