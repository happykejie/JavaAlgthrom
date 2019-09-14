package com.vivo前端;

/*
* 利用栈实现
* */
import  java.util.*;
public class 礼物问题 {

    public  static  void  main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = "(()(()((()(0)))))";

        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length();i++){

            if(str.charAt(i) == ')'){
                st.pop();
            }
            else  if(str.charAt(i) =='0'){
                System.out.println(st.size());
            }
            else {
                st.push(str.charAt(i));
            }
        }
    }
}
