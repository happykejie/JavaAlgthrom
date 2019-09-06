package com.tengxu2;

import  java.util.*;
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum[] = new int[n];
        int b[] = new int[n];
        int s=0;
        for(int i=0;i<n;i++){
            b[i] = scanner.nextInt();
            s+=b[i];
            sum[i]= s;
//			System.out.print(sum[i]+" ");
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int j=i-1,k=i+1;
            int min = b[i];
            while(j>=0 && b[i]<b[j]){
                min = min>b[j]?b[j]:min;
                j--;
            }
            while(k<n && b[i]<b[k]){
                min = min>b[k]?b[k]:min;
                k++;
            }
            if(j==-1 && k!=n){
                ans = Math.max(ans, (sum[k]-b[k])*min);
            }else if(j!=-1 && k==n){
                ans = Math.max(ans, (sum[k-1]-sum[j])*min);
            }else if(j==-1 && k==n){
                ans = Math.max(ans, (sum[k-1])*min);
            }else{
                ans = Math.max(ans, (sum[k-1]-sum[j])*min);
            }

        }
        System.out.println(ans);
    }

}
