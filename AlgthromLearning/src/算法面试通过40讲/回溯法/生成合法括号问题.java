package 算法面试通过40讲.回溯法;

import java.util.ArrayList;
import java.util.List;

public class 生成合法括号问题 {

    public  static  void main(String[] args){
        List<String> list  = generateParenthesis(3);
        for(String str : list){
            System.out.println(str);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        findgenerateParenthesis(n,n,"",res);
        return res;
    }
    //left和right分别表示左右括号的个数
    public static void  findgenerateParenthesis(int left,int right,String out,List<String> res){
        if(left < 0 || right < 0 || left > right){  //left > right是")("的情况
            return ;
        }
        if(left == 0 && right == 0){
            res.add(out);
            return;
        }
        findgenerateParenthesis(left - 1, right, out + "(", res);//回溯
        findgenerateParenthesis(left, right - 1, out + ")", res);
    }
}
