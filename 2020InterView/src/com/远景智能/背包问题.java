package com.远景智能;

/**
 * 某风力电场每台风机的发电量和距离升压台的距离各不相同，如风机1：发电量30，距离20 ，风机2：发电量35，距离25；....,
 * 要求在输电总距离限定如小于100的前提下，选择风机向升压站输电，使得输出的电量最大
 *
 * 风机距离：如 30，20，35，40
 * 风机发电量： 20，18，25，30
 * 输电总距离限制，如 50
 *
 * //这题是典型的0-1背包问题
 * */
public class 背包问题 {


    public  static  void main(String[] args){

        //风机距离
        int[] Dis = {30,20,35,40};
        //风机发电量
        int[] Pow = {20,18,25,30};
        int nums = Dis.length;
        int limit = 50;


        //利用优化的0-1背包问题解决
        int maxporw  = ZeroOnePack2(limit,nums,Dis,Pow);

        System.out.println(maxporw);


        //二维动态规划， 并得到那些元素加入。
        int[][] dp = new int[nums+1][limit+1];



        for(int i=1;i<=nums;i++){

            for(int j=1; j<=limit; j++){

                if(Dis[i-1]>j) //如果加入的风机距离大于当前剩余限制距离
                {
                    dp[i][j] = dp[i-1][j]; // 不加入，则最大值等于上一个风机加入时候同样容量情况。因为没有加入，所以最大保持不变
                }
                else {
                    //dp[i-1][limit-Dis[i-1]] 表示， 之前加入的最大值，
                    dp[i][j] =Math.max(dp[i-1][j],dp[i-1][limit-Dis[i-1]]+Pow[i-1]);
                }
            }

        }

        //则限制的最大值
        int maxValue = dp[nums][limit];
        System.out.println("最大值："+maxValue);

        //逆推找出加入的风机

        int j = limit; //限制距离
        String numStr ="";

        StringBuffer sb = new StringBuffer();

        for(int i= nums; i>0;i--){
            //如果dp[i][j]>dp[i-1][j] ,这说明第i 件物品时加入的。
            if(dp[i][j]>dp[i-1][j]){
                 int index  = i-1;
                sb.append(index+" ");
                j=j-Dis[i-1];
            }
            if(j==0){
                break;
            }
        }

        System.out.println(sb.toString());

    }


    /**
     * 0-1背包的优化解法
     * 思路：
     * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
     * 用逆序来实现
     */
    public static int ZeroOnePack2(int V,int N,int[] weight,int[] value){
        //动态规划
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //逆序实现
            for(int j=V;j>=weight[i-1];j--){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];
    }




}
