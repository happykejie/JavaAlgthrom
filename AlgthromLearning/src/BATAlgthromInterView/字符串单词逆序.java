package BATAlgthromInterView;

import java.util.Scanner;

public class 字符串单词逆序 {

    public  static  void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个字符串str1:");
        //String str1 = sc.next(); //空格结束
        String str1 = sc.nextLine();
        System.out.println("str1="+str1);

        char[] chas = str1.toCharArray();

        //逆序句子
        rotateWord(chas);

        //打印逆序后的句子：
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<chas.length;i++){

            sb.append(chas[i]);
        }
        System.out.println(sb.toString());

    }

    //// 反转句子
    public static   void   rotateWord(char[] chas)
    {
        if(chas == null || chas.length ==0)
        {
            return;
        }
        //反转整个句子
        reverse(chas,0 ,chas.length-1);
        int left = -1;
        int right = -1;
        for(int i=0; i<chas.length;i++)
        {
            if(chas[i] !=' ')
            {   
                //获取每个单词的开始和结束位置
                left= i==0 || chas[i-1] == ' '?i : left;
                right = i == chas.length-1 || chas[i+1] == ' '? i : right;
            }
            if(left !=-1 && right != -1){
                reverse(chas,left,right);
                left=-1;
                right=-1;
            }
        }

    }

    public  static  void  reverse(char[] chas,int start,int end){
        char tmp =0;
        while (start<end){
            tmp = chas[start];
            chas[start]=chas[end];
            chas[end]=tmp;
            start++;
            end--;
        }

    }
}
