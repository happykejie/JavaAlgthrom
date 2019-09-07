package 算法面试通过40讲.回溯法;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 销售业绩考核 优秀的A， 合格为B， 较差为C，公司年底都会生成n个月（n<=m）的业绩。 如果业绩中超过一个C，或者超过连续的B，则不会对该员工发放业绩奖金。
 * 请给出所有可能的奖励情况数量。
 * */
public class 绩效发放 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String grade = "ABC";
        List<List<Character>> result = new ArrayList<>();
        List<Character> temp = new ArrayList<>();
        backTracing(m, grade, result, temp);
        System.out.println(result.size());


    }

    public static void backTracing(int m, String grade, List<List<Character>> result, List<Character> temp){
        if(temp.size() == m){
            if(match(temp)){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i = 0 ; i < grade.length() ; i++){
            temp.add(grade.charAt(i));
            backTracing(m, grade, result, temp);
            temp.remove(temp.size()-1);
        }
    }
    public static boolean match(List<Character> temp) {
        // 判断C的个数是否大于1
        int c_count = 0;
        for (Character c : temp) {
            if (c == 'C') {
                c_count++;
            }
            if (c_count > 1) {
                return false;
            }
        }
        //判断是否有三个以上B
        for (int j = 0; j < temp.size(); j++) {
            if(j+2<temp.size()) {
                if (temp.get(j) == 'B' && temp.get(j + 1) == 'B' && temp.get(j + 2) == 'B') {
                    return false;
                }
                j++;
            }
        }
        return true;
    }

}






