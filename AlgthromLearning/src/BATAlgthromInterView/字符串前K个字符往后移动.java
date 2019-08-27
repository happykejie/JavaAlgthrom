package BATAlgthromInterView;

import java.util.Scanner;

public class 字符串前K个字符往后移动 {

    public  static  void  main(String[] args){

        Scanner sc  = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        char[] chas = str.toCharArray();

        if(k>chas.length-1)
        {
            k= chas.length-1;
        }
        if(k>0) {


            //1) 先将str[0...k] 部分的字符串逆序
            reverse(chas, 0, k);

            //2)将str[i+1-N-1] 部分的逆序
            reverse(chas, k+1, chas.length - 1);

            //3）将str整体的字符逆序
            reverse(chas, 0, chas.length - 1);

            //打印逆序后的句子：
            StringBuffer sb = new StringBuffer();

            for(int i=0; i<chas.length;i++){

                sb.append(chas[i]);
            }
            System.out.println(sb.toString());
        }

    }

    public  static  void reverse(char[] chas, int start, int end)
    {
        char tmp =0;
        while (start<end){
            tmp = chas[start];
            chas[start]= chas[end];
            chas[end] =tmp;
            start++;
            end--;
        }
    }
}
