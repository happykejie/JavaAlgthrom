package Algthrom40ti;

import java.util.*;
public class 生成有效括号 {

    private List<String> list;
    List<Character> brackets;

    public  static  void main(String[] args){

        生成有效括号 ts = new 生成有效括号();
        List<String> list = ts.generateParenthesis(3);
        for(int i =0; i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

    public    List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        brackets = new ArrayList<>();
        brackets.add('(');
        brackets.add(')');
        //暴力实现
        generateParenthesis(new StringBuilder(), 0, n);
        return list;
    }

    //stringBuilder中存储了索引为0 ~ (index - 1)的字符，现在考虑第index索引位置的字符
    private  void generateParenthesis(StringBuilder stringBuilder, int index, int n) {
        if(index == 2 * n) {
            if(isValidString(stringBuilder.toString())) {
                list.add(stringBuilder.toString());
            }
            return;
        }
        for(int i = 0; i < brackets.size(); i++) {
            stringBuilder.append(brackets.get(i));
            generateParenthesis(stringBuilder, index + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    private  boolean isValidString(String string) {
        int leftCount = 0;
        int rightCount = 0;
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == '(') {
                leftCount++;
            }else {
                rightCount++;
            }
            if(rightCount > leftCount) {
                return false;
            }
        }
        return rightCount == leftCount;
    }

    /**
     * 在递归的过程中，只有在我们知道序列仍然保持有效时才添加 '(' or ')' ，而不是像思路一那样每次添加。我们可以通过设置两个变量leftCount和rightCount来分别跟踪到目前为止放置的左括号和右括号的数目来做到这一点。
     *
     * 回溯过程中注意以下几点。
     *
     * （1）在Solution类中新建内部的私有成员变量，可以防止递归函数中一直传递该变量。
     *
     * （2）注意相关变量的手动回溯。
     * */
    //stringBuilder中存放了leftCount个左括号，rightCount个右括号
    private void generateParenthesis2(StringBuilder stringBuilder, int leftCount, int rightCount, int n) {
        if(leftCount + rightCount == 2 * n) {
            list.add(stringBuilder.toString());
            return;
        }
        if(leftCount == rightCount) {
            stringBuilder.append(brackets.get(0));
            generateParenthesis2(stringBuilder, leftCount + 1, rightCount, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }else if(leftCount > rightCount) {
            if(leftCount == n) {
                stringBuilder.append(brackets.get(1));
                generateParenthesis2(stringBuilder, leftCount, rightCount + 1, n);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }else if(leftCount < n) {
                for(int i = 0; i < brackets.size(); i++) {
                    stringBuilder.append(brackets.get(i));
                    if(i == 0) {
                        generateParenthesis2(stringBuilder, leftCount + 1, rightCount, n);
                    }else {
                        generateParenthesis2(stringBuilder, leftCount, rightCount + 1, n);
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
    }


}
