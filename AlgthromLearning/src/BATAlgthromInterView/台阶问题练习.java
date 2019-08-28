package BATAlgthromInterView;

public class 台阶问题练习 {

    public  static  void  main(String[] args){

        int resutl = countWays(5);

        System.out.println("result:"+resutl);

    }

    public static   int countWays(int n){
        if(n<0){
            return  0;
        }
        if(n ==1 ||n ==2){
            return  n;
        }
//        return  countWays(n-1)+ countWays(n-2);

        int res =2;
        int pre =1;
        int tmp =0;
        for(int i=3; i<=n; i++){
            tmp = res;
            res = (pre+res)%1000000007;
            pre = tmp;
        }
        return  res;


    }
}
