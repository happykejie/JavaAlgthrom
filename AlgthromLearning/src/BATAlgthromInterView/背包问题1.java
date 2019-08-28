package BATAlgthromInterView;

/**
 *
 * 小v负责次活动礼品采购，每款礼品的受欢迎程度（热度值）各不相同。现给出总金额以及各礼品的单价和热度值，且每个礼品只采购一个，如何购买可以使得所有礼品的总热度值最高。
 * 输入：
 *
 *     第一行是一个正整数，表示总金额（不大于1000）
 *     第二行是一个长度为n的正整数数组，表示礼品单价（n不大于100）
 *     第三行是一个长度为n的正整数数组，表示对应礼品热度值
 *
 * 输出：
 * 一个正整教，表示可获得的最高总热度值
 * 样例输入：1000
 *                   200 600 100 180 300 450
 *                   6 10 3 4 5 8
 * 样例输出：21
 *  ————————————————
 * 版权声明：本文为CSDN博主「_fingers_dancer」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/Tona_ZM/article/details/90904969
 * */
public class 背包问题1 {


    /*
     * 动态规划算法求解，时间O(NV),空间O(V)
     */
    public int ZeroOnePackDP(int V,int[] weight,int[] value){
        int N=weight.length;
        int[] dp = new int[V+1];
        //前i件、承重为j的最大热度
        for(int i=1;i<N+1;i++){
            /*
             *根据动态规划“由下而上”的思想可知，要求的第i步的最优解我们只需要根据第i-1步的最优解即
             *可求得，并且现在是一维数组，所以我们需要对f[j]从后往前更新，这里一定要想明白！
             */
            for(int j=V;j>=weight[i-1];j--){
                //weight和value数组下标是从0开始，而dp数组是从1开始
                dp[j]=Math.max(dp[j-weight[i-1]]+value[i-1], dp[j]);
            }
        }
        return dp[V];
    }



    /*
     * 贪心算法求解,时间(N平方),空间(N)
     */
    public int ZeroOnePackGreedy(int V,int[] weight,int[] value){
        int N=weight.length;
        double[] r= new double[N];  //性价比数组
        int[] index=new int[N];  //按性价比排序的物品的下标
        for(int i=0;i<N;i++){
            r[i]=(double)value[i]/weight[i];
            index[i]=i;  //先是默认排序
        }

        double tempD = 0;//下面对性价比数组进行排序,从大到小
        int tempI = 0;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(r[j]>r[i]){
                    tempD = r[i];
                    r[i]=r[j];
                    r[j]=tempD;
                    tempI = index[i];
                    index[i] = index[j];
                    index[j] = tempI;
                }
            }
        }

        int result=0;
        for(int i=0;i<N;i++){
            if(weight[index[i]] <= V){  //表明还可以装得下
                result += value[index[i]];
                V -= weight[index[i]];
            }
        }
        return result;
    }



}
