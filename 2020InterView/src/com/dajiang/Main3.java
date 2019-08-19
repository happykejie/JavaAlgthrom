package com.dajiang;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt(); //顶点
            int p = scanner.nextInt(); //边
            int c = scanner.nextInt(); //
            int cost[][] = new int[n][n]; //
            boolean visited[] = new boolean[n]; //标记
            int distance[] = new int[n]; //最短距离
            Arrays.fill(visited, false);
//Arrays.fill(cost, 1000000);
            Arrays.fill(distance,100000);
            distance[0]=0;
            for(int i=0;i<n;i++){
                for(int k=0;k<n;k++){
                    cost[i][k] = 100000;
                }
            }
            for(int i=0;i<p;i++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                cost[x][y] = z;
                cost[y][x] = z;
            }

            while(true){
                int v= -1;
                for(int i=0;i<n;i++){
                    if(!visited[i] && (v==-1 || distance[i]<distance[v])){
                        v = i;
                    }
                }
                if(v==-1){
                    break;
                }
                visited[v] = true;
                for(int k=0;k<n;k++){
                    distance[k] = Math.min(distance[k], distance[v]+cost[v][k]);
                }
            }
            int sum=0;
            for(int k=0;k<c;k++){
                int xx = scanner.nextInt();
                sum+=distance[xx];
            }
            System.out.println(sum);

        }
    }

}
