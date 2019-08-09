package base.grammar;

/**
 * 字符串广泛应用 在 Java 编程中，在 Java 中字符串属于对象，Java 提供了 String 类来创建和操作字符串。
 * */

public class JavaString类 {

    public static void main(String args[]){


        /**
         *  注意:String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了（详看笔记部分解析）。
         *
         * 如果需要对字符串做很多修改，那么应该选择使用 StringBuffer & StringBuilder 类。
         * */

        char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
        String helloString = new String(helloArray);
        System.out.println( helloString );

        String site = "www.runoob.com";
        int len = site.length();
        System.out.println( "菜鸟教程网址长度 : " + len );

        /**
         * 连接字符串
         *
         * String 类提供了连接两个字符串的方法：
         * string1.concat(string2);
         *
         * "Hello," + " runoob" + "!"
         * */

        String string1 = "菜鸟教程网址：";
        System.out.println("1、" + string1 + "www.runoob.com");
    }
}
