package class08;

public class Test {

    public  static  int minPath(int[][] m)
    {
        return  f(m,0,0);
    }

    //递归过程含义-暴力递归遍历没有任何优化
    //从row 行 col 列 出发,到达右下角，所有可能路径中，最小的路径和返回
    public  static  int f(int[][] m, int row,int col)
    {
        if(row == m.length-1 && col == m[0].length-1){ //到达终点
            return m[row][col];
        }
        if(col == m[0].length-1) //如果到达最后一列，只能往下走
        {
            int ans = m[row][col] + f(m,row+1,col);
            return  ans;
        }
        if(row == m.length -1)
        {
            int ans = m[row][col] + f(m,row,col+1);
            return  ans;
        }
        int p1 = m[row][col] + f(m,row,col+1);
        int p2 = m[row][col] + f(m,row+1,col);
        int ans = Math.min(p1,p2);
        return  ans;
    }

    //以上暴力递归存在大量重复计算，可以通过以下记忆化搜索（缓存）减少重复计算

    public  static  int minPath2(int[][] m){
        int[][] ansMap = new int[m.length][m[0].length];
        //可以再用一个bool 类型数组记录是否真的计算过。这里不记录，简单用-1表示即可。
        boolean[][] iscul = new boolean[m.length][m[0].length];

        for(int i=0; i< ansMap.length;i++)
        {
            for(int j=0; j<ansMap[0].length;j++)
            {
                ansMap[i][j] = -1;
            }
        }
        return f2(m,0,0,ansMap);
    }
    // 记忆化搜索实现——原理就是把计算过一遍的数据存入缓存字典，避免重复计算.可变参数存入缓存
    public  static  int f2(int[][] m, int row,int col,int[][] ansMap){

        //首先判断缓存里面是否计算过，如果计算过直接返回答案
        if(ansMap[row][col] !=1)
        {
            return ansMap[row][col];
        }
        int ans =0;
        if(row == m.length-1 && col == m[0].length-1){ //到达终点
            ans = m[row][col];
            ansMap[row][col] = ans;
            return m[row][col];
        }
        if(col == m[0].length-1) //如果到达最后一列，只能往下走
        {
            ans = m[row][col] + f(m,row+1,col);
            ansMap[row][col] = ans;
            return  ans;
        }
        if(row == m.length -1)
        {
            ans = m[row][col] + f(m,row,col+1);
            ansMap[row][col] = ans;
            return  ans;
        }
        int p1 = m[row][col] + f(m,row,col+1);
        int p2 = m[row][col] + f(m,row+1,col);
        ans = Math.min(p1,p2);
        ansMap[row][col] = ans;
        return  ans;
    }

    /// 动态规划——就是优化细节的位置依赖关系，调整位置依赖，使计算更加高效

    //下面通过动态规划实现
    public  static  int dpMinPath(int[][] m)
    {
        int[][] dp = new int[m.length][m[0].length];
        int N = m.length;
        int M = m[0].length;
        dp[N-1][M-1] = m[N-1][M-1];
        for(int row = N-2; row>=0; row--)
        {
            dp[row][M-1] =m[row][M-1] +dp[row+1][M-1];
        }
        for (int col = M-2;col>=0;col--)
        {
            dp[N-1][col] = m[N-1][col] +dp[N-1][col+1];
        }
        for(int row = N-2; row>=0;row--)
        {
            for(int col = M-2;col>=0;col--)
            {
                int p1= m[row][col] +dp[row][col+1];
                int p2 = m[row][col] +dp[row+1][col];
                dp[row][col] =Math.min(p1,p2);
            }
        }
        return dp[0][0];
    }



}
