package BATAlgthromInterView.暴力递归;

import  java.util.*;
public class 换钱的最少货币数 {

    public  static  void main(String[] args){

        int[] arr = {5,2,3};
        int result =0;

        result = minCoins1(arr,20);

        System.out.println(result);


    }

    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process(arr, 0, aim);
    }


    // 当前考虑的面值是arr[i]，还剩rest的钱需要找零
    // 如果返回-1说明自由使用arr[i..N-1]面值的情况下，无论如何也无法找零rest
    // 如果返回不是-1，代表自由使用arr[i..N-1]面值的情况下，找零rest需要的最少张数
    public static int process(int[] arr, int i, int rest) {
        // base case：
        // 已经没有面值能够考虑了
        // 如果此时剩余的钱为0，返回0张
        // 如果此时剩余的钱不是0，返回-1
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        // 最少张数，初始时为-1，因为还没找到有效解
        int res = -1;
        // 依次尝试使用当前面值(arr[i])0张、1张、k张，但不能超过rest
        for (int k = 0; k * arr[i] <= rest; k++) {
            // 使用了k张arr[i]，剩下的钱为rest - k * arr[i]
            // 交给剩下的面值去搞定(arr[i+1..N-1])
            int next = process(arr, i + 1, rest - k * arr[i]);
            if (next != -1) { // 说明这个后续过程有效
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;
    }
}
