package 算法面试通过40讲;

import  java.util.*;
import  java.io.*;
public class 判断链表是否有环 {

    //方法一： 利用时间截止判断，1秒还没到null ，说明右环

    //方法二： set 存储node 是否重复 O(N)， 空间复杂的O(N)

    //方法三： 快. 慢指针

    public  static  void main(String[] args){

        long startTime=System.currentTimeMillis();
        LinkedNode head = new LinkedNode(1);
        boolean result = method1(head,startTime);
        System.out.println("是否有环："+result);

    }

    public  static  boolean method1(LinkedNode head,long startTime){
       while (head.next != null){
           long endTime = System.currentTimeMillis();
           long setime = (endTime - startTime);
           if(setime>1000)
           {
               return false;
           }
           head = head.next;

       }
       return true;
    }

    public  static  boolean method2(LinkedNode head){
        HashSet<LinkedNode>  hs = new HashSet<LinkedNode>();
        while (head.next != null)
        {
            boolean repeat = hs.add(head);
            if(repeat) {
                return  false;
            }
            head = head.next;
        }
        return  true;
    }

    public static  boolean method3(LinkedNode head){
        LinkedNode j = head;
        LinkedNode i = head;
        while (i.next != null){
            i =i.next;
            j = i.next.next;
            if(i == j){
                return  false;
            }

        }
        return true;
    }

}
