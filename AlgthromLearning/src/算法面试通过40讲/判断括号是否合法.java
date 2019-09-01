package 算法面试通过40讲;

import java.util.HashMap;
import java.util.Stack;

public class 判断括号是否合法 {


    public  static  void main(String[] args){

        // 利用栈实现， 左进栈， 右进栈判断与栈顶左判断是否匹配。
        HashMap<String,String> hm = new HashMap<String,String>();
        hm.put(")","(");
        hm.put("}","{");
        hm.put("]","[");
        Stack<String> st = new Stack<String>();
        String teststr = "{}[]()";
        char[] carr = teststr.toCharArray();
        for(char s : carr){
            if(!hm.containsKey(String.valueOf(s))){
                st.push(String.valueOf(s));
            }
            if(st.size()<1){
                System.out.println("不匹配");
            }
            if(hm.get(String.valueOf(s)) != st.pop()){
                System.out.println("不匹配");
            }
        }

        if(st.size()==0){
            System.out.println("合法的");

        }



    }


    /// 方法2： 两两匹配的消除， 直到为空。但是时间复杂度高




}
