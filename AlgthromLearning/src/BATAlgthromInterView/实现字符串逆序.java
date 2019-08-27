package BATAlgthromInterView;

import java.util.Stack;

public class 实现字符串逆序 {

    public static void main(String[] args) {

        String string = "123abcd";
        // StringBuffer sb = new StringBuffer(string);
        string = reverse3(string);
        // System.out.println(sb.reverse().toString());
        System.out.println(string);


        String s="课慕有唯，忧解以何";
//方法一 将字符串转换为字符数组
        char[] arr =s.toCharArray();
//逆序输出字符数组
        for(int i=arr.length-1;i>=0;i--){
            System.out.print(arr[i]);
        }
        System.out.println("\n-----------------");
//方法二 将字符串转换为字符数组
        char[] arr2 =s.toCharArray();
        for(int i=0;i<arr.length/2;i++)
        {
            char temp;
            temp=arr2[i];
            arr2[i]=arr2[arr.length-i-1];
            arr2[arr.length-i-1]=temp;
        }
        System.out.println(new String(arr2));
        System.out.println("----------------");
//方法三 利用StringBuffer实现翻转
        StringBuffer sb=new StringBuffer(s);
        System.out.println(sb.reverse());
    }


    public static String reverse3(String string) {
        StringBuffer sb = new StringBuffer();
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < string.length(); i++) {
            s.add(string.charAt(i));
        }
        for (int i = 0; i < string.length(); i++) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static String reverse1(String string) {
        StringBuffer sb = new StringBuffer(string);
        for (int i = 0, j = sb.length() - 1; i < sb.length() >>> 1; i++, j--) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
        }
        return sb.toString();
    }

    public static String reverse2(String string) {
        StringBuffer sb = new StringBuffer();
        for (int i = string.length() - 1; i >= 0; i--) {
            sb.append(string.charAt(i));
        }
        return sb.toString();
    }



}
