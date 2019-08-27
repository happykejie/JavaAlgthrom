package class07;

//找钱方法数
public class CoinWays {

    // arr 里都是正数，没有重复值，每一个值代表一种货币，每一种都可以用无限张
    // 最终要找零数是aim
    // 找零方法返回
    public static  int way1(int[] arr, int aim){
        return  process(arr,0,aim);
    }

    // 可以自由使用arr[0...index] 所有的货币
    // 需要搞定的钱数是rest
    // 返回找零的方法数
    public  static  int process(int[] arr,int index,int rest)
    {
        // 已经没有货币选了。只有找的钱数是零，才能满足
        if(index == arr.length){ //base case
            return  rest==0?1:0;
        }
        // arr[index]  0张，1张 .. 不要超过rest的钱数
        int ways = 0;
        for(int zhang =0; arr[index] * zhang <= rest; zhang++) // 每一个张数都去尝试
        {
            ways += process(arr,index+1, rest-arr[index]*zhang);

        }
        return ways;
    }


}
