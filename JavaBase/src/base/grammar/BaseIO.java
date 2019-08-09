package base.grammar;
import  java.util.*;

import  base.grammar.JavaClassObj;

public class BaseIO {
    public  static  void main(String[] args) {
        System.out.println("nihao!");

        Employee employee = new Employee("test");


//        预先不输入数据的组数——读到文件结尾

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }

//        预先知道数据的组数——读数据组数后循环
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            int a= sc.nextInt();
            int b = sc.nextInt();
            System.out.println("case "+(a + b)+"\n");
        }

        String getstr  = sc.nextLine();
    }
}
