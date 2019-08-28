package BATAlgthromInterView;

public class 最长递增子序列问题 {

    public  static  void main(String[] args){

        int[] arr ={2,1,5,3,6,4,8,9,7};

        if(arr == null || arr.length == 0){
            return;
        }

        int[] dp = getdp1(arr);
        int[] lis = generateLIS(arr,dp);

        StringBuffer sb = new StringBuffer();

        for(int item : lis){
            sb.append(String.valueOf(item));
        }

        System.out.println(sb.toString());

    }

    // 动态规划1 时间复杂度o(n^2)
    public  static  int[] getdp1(int[] arr){
        int[] dp = new int[arr.length];
        for(int i=0; i<arr.length;i++){
            dp[i] =1;
            for(int j=0; j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return  dp;
    }

    public  static  int[] generateLIS(int[] arr, int[] dp){
        //查询最大的dp 值
        int len =0;
        int index =0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>len){
                len = dp[i];
                index =i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index]; //最后一个数，及dp截至位置
        for(int i=index; i>=0;i--){
            if(arr[i]<arr[index] && dp[i] == dp[index]-1){
                lis[--len] = arr[i];
                index =i;
            }
        }

        return  lis;

    }

}
