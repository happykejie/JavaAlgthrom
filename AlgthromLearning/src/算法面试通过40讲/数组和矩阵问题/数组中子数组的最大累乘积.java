package 算法面试通过40讲.数组和矩阵问题;

import java.text.DecimalFormat;

public class 数组中子数组的最大累乘积 {

    public  static  void main(String[] args){
        double[] arr ={-2.5,4,0,3,0.5,8,-1};

        double b=10/3.0;
        System.out.println(b);

        DecimalFormat df = new DecimalFormat( "0.00 ");
        System.out.println(df.format(maxProduct(arr)));
    }

    public  static  double maxProduct(double[] arr){

        if(arr== null || arr.length ==0){
            return  0;
        }

        double max = arr[0];
        double min = arr[0];
        double res = arr[0];
        double maxEnd = 0;
        double minEnd = 0;
        double result = arr[0];

        for(int i=1; i<arr.length; i++){
            maxEnd = max * arr[i];
            minEnd = min * arr[i];
            max  = Math.max(Math.max(maxEnd,minEnd),arr[i]);
            min  = Math.min(Math.min(maxEnd,minEnd),arr[i]);
            res = Math.max(max,min);

            if(res>result){
                result = res;
            }
        }
        return  result;

    }



}
