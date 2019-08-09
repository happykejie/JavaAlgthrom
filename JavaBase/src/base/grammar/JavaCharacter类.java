package base.grammar;


/**
 *
 * Character 类用于对单个字符进行操作。
 *
 * Character 类在对象中包装一个基本类型 char 的值
 */

public class JavaCharacter类 {
    public static void main(String args[]) {
        System.out.println("访问\"菜鸟教程!\"");


        System.out.println(Character.isLetter('c'));
        System.out.println(Character.isLetter('5'));

//        isWhitespace() 方法用于判断指定字符是否为空白字符，空白符包含：空格、tab 键、换行符。
        System.out.println(Character.isWhitespace('c'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.isWhitespace('\n'));
        System.out.println(Character.isWhitespace('\t'));

//        isDigit() 方法用于判断指定字符是否为数字。
/**
 *
 * isUpperCase()
 * 是否是大写字母
 * 5 	isLowerCase()
 * 是否是小写字母
 * 6 	toUpperCase()
 * 指定字母的大写形式
 * 7 	toLowerCase()
 * 指定字母的小写形式
 * 8 	toString()
 * 返回字符的字符串形式，字符串的长度仅为1
 * */
    }
}
