package com.远景智能;

import java.util.Arrays;

/**
 * 给定一个排好序的数组，两个整数K 和 x ,从数组中找到最靠近 X （两数之差最小） 的 K 个数。
 * 返回的结果必须要安装升序排行的。
 * 如果有两个数与 X 的差值一样，优先选择数值较小的那个数
 *
 * 输入第一行 数组 arr
 * 查找 个数 K
 * 基准 x
 *
 * 样例
 * 1，2，3，4，5
 * 4
 * 3
 * 输出：1 ，2，3，4
 * */
public class 找离某个数最近的K个数 {

    public  static  void  main(String[] args){
        int[] arr ={1,3,6,7,9,13,18,20,25,30,40};
        int k =4;
        int x=17;
        int xindex = 0;
        boolean isfindx = false;
        //如果没有找到X
        // 通过这班查找，查找最近X的数返回
        int left=0, right=0;
        for(right= arr.length-1; left!=right;){
            int midIndex = left +((right-left)>>1);
            int mid = right-left;
            int midValue = arr[midIndex];
            if(x == midIndex){
                isfindx = true;
            }

            if(x>midValue){
                left = midIndex;
            }
            else {
                right = midIndex;
            }

            if(mid<=2){
                break;
            }
        }
        int[] findk = new int[k];
        int i=0;
        if(!isfindx){ //刚刚有匹配的
            xindex = Math.abs(arr[left]-x)>Math.abs(arr[right]-x)?right:left;
            k--;
            i++;
            findk[0]= arr[xindex];
        }
        if(isfindx){
            k--;
            i++;
            findk[0]= arr[xindex];
        }
        if(k>0 && k<arr.length) {
            int Lmindistance =0;
            int Rmindistance = 0;
            int L = xindex-1; // 从最左边第二开始找
            int R = xindex+1; // 从右边第一个开始找
            int num =1;
            while (num<=k) { //已经默认找到一个
                 if(L>=0 && R<=arr.length) {
                     Lmindistance = Math.abs(arr[xindex] - arr[L]);
                     Rmindistance = Math.abs(arr[xindex] - arr[R]);
                     if (Lmindistance > Rmindistance) {
                         findk[i] = arr[R];
                         R++;
                         i++;
                         num++;
                         continue;
                     } else {
                         findk[i] = arr[L];
                         L--;
                         i++;
                         num++;
                         continue;
                     }
                 }
                 //右边没有，左边还有，只有添加左边的
                 if(L>0 && R==arr.length+1){
                     findk[i] = arr[L];
                     L--;
                     i++;
                     num++;
                     continue;
                 }
                //右边没有，左边还有，只有添加左边的
                if(L<0 && R<arr.length){
                    findk[i] = arr[R];
                    R++;
                    i++;
                    num++;
                    continue;
                }
            }
        }
        else {
            findk =null; //清空数组
        }
        Arrays.sort(findk); ///排序，从小到大
        StringBuffer sb = new StringBuffer();
        for(int j = 0;j<findk.length;j++){
            if(j==findk.length-1){
                sb.append(String.valueOf(findk[j]));
            }
            else {
                sb.append(String.valueOf(findk[j])+",");
            }
        }
        System.out.println("结果："+sb.toString());
    }
}
