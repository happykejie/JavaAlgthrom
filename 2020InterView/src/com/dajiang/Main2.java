package com.dajiang;
import java.util.*;
public class Main2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int T=sc.nextInt();
            int a[]=new int[n+1];
            int b[]=new int[n+1];
            int c[]=new int[n+1];
            int f[]=new int[T+1];
            for(int j=1;j<=n;j++){
                a[j]=sc.nextInt();
                b[j]=sc.nextInt();
                c[j]=sc.nextInt();
            }
            int maxl=fun(a,b,c,f,T,n);
            System.out.println(maxl);
        }
    }
    public static int fun(int a[],int b[],int c[],int f[],int T,int n){
        for(int k=1;k<n+1;k++){
            for(int t=T;t>=a[k];t--){
                int minnum=Math.min(c[k],t/a[k]);
                for(int s=1;s<=minnum;s++){
                    if(f[t]<f[t-s*a[k]]+s*b[k])
                        f[t]=f[t-s*a[k]]+s*b[k];
                }
            }
        }
        return f[T];
    }
}
