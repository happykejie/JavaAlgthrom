package com.tengxu2;
import java.util.Scanner;
import  java.util.*;
public class Main1{

    public static int n = 0, m = 0;

    public static boolean dfs(int[][] map, boolean[] used, int[] linked, int start) {
        for(int i = 0;i < m;i++) {
            if(used[i] == false && map[start][i] == 1) {
                used[i] = true;
                if(linked[i] == -1 || dfs(map, used, linked, linked[i])) {
                    linked[i] = start;
                    return true;
                }
            }
        }
        return false;
    }

    public static int getMaxNum(int[][] map) {
        int count = 0;
        int[] linked = new int[m];
        for(int i = 0;i < m;i++)
            linked[i] = -1;
        for(int i = 0;i < n;i++) {
            boolean[] used = new boolean[m];  //初始化m部分顶点均为被访问
            if(dfs(map, used, linked, i))  //从顶点i出发能够得到一条增广路径
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] boxArr = new int[n];
        int[] keyArr = new int[m];
        for(int i = 0 ; i < boxArr.length ; i++){
            boxArr[i] = sc.nextInt();
        }
        for(int i = 0 ; i < keyArr.length ; i++){
            keyArr[i] = sc.nextInt();
        }

        int[][] map = new int[n][m];

        for(int i = 0 ; i < boxArr.length ; i++){
            for(int j = 0 ; j < keyArr.length ; j++){
                if(boxArr[i] + keyArr[j] % 2 == 1){
                    map[i][j] = 1;
                }
            }
        }
        System.out.println(getMaxNum(map));
    }
}