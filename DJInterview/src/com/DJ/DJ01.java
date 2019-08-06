
package com.DJ;
import java.util.Scanner;

public class DJ01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int k = 0; k < c; k++) {
            int N = sc.nextInt();
            int V = sc.nextInt();
            int[] weight = new int[N];
            int[] value = new int[N];
            for (int i = 0; i < N; i++) {
                int a1 = sc.nextInt();
                value[i] = a1;
                int a2 = sc.nextInt();
                weight[i] = a2;
            }
            int zeroOnePack2 = ZeroOnePack(V, N, weight, value);
            System.out.println(zeroOnePack2);
        }
    }
    public static int ZeroOnePack(int V, int N, int[] weight, int[] value) {
        int[] ts = new int[V + 1];
        for (int i = 1; i < N + 1; i++) {

            for (int j = V; j >= weight[i - 1]; j--) {
                ts[j] = Math.max(ts[j - weight[i - 1]] + value[i - 1], ts[j]);
            }
        }
        return ts[V];
    }
}