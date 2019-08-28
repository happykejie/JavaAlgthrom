package BATAlgthromInterView;

public class 矩阵最小路径问题 {

    public  static  void  main(String[] args){

    }

    public  static  int getMin(int[][] Map){

        if(Map == null ||Map.length == 0 || Map[0] == null || Map[0].length ==0){
            return 0;
        }
        int row = Map.length;
        int col = Map[0].length;
        //分析位置依赖，采用动态规划来实现
        int[][] dp  = new int[row][col];
        dp[0][0] = Map[0][0];
        //填表第一列数据
        for(int i=1; i<row; i++){
            dp[i][0] = dp[i-1][0]+Map[i][0];
        }

        //填表第一行数据
        for(int i=1; i<col; i++){
            dp[0][i] = dp[0][i-1]+Map[0][i];
        }
        //从左往右，从上往下推其他表格数据
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+Map[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
