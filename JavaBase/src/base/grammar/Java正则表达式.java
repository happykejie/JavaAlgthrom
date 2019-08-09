package base.grammar;

/**
 *  ^ 定义了以什么开始
 *
 * \d+ 匹配一个或多个数字
 *
 * ? 设置括号内的选项是可选的
 *
 * \. 匹配 "."
 *
 * 可以匹配的实例："5", "1.5" 和 "2.21"。
 * */
import  java.util.regex.*;
public class Java正则表达式 {

    public static void main(String args[]){
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }
}
