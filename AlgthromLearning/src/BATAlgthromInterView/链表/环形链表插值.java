package BATAlgthromInterView.链表;

import java.util.List;

/**
 * Created by xing on 4/28/17.
 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 测试样例：
 [1,3,4,5,7],[1,2,3,4,0],2
 返回：{1,2,3,4,5,7}
 */

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class 环形链表插值 {

     public  static  void  main(String[] args){


     }

    public ListNode insert(int[] A, int[] nxt, int val) {

        //如果为空，建立独立的环形链表
        if(A ==null || A.length == 0){
            return  new ListNode(val);
        }
        //建立环形链表
        ListNode root = new ListNode(A[0]);
        root.next = root;
        ListNode cur = root;

        for(int i=0; i<A.length-1;i++){
            // nxt 编号对应值
            ListNode node = new ListNode(A[nxt[i]]);
            cur.next = node; //根节点指向下一个
            cur = cur.next; // 当前节点指向最新加入节点
        }
        //插入操作

        ListNode pre = root;
        ListNode next = root.next;
        ListNode node = new ListNode(val);
        if(root.val>=val){ //插入节点最小
            node.next = node; //新增节点插入根节点前面
            return  node;
        }
        while (next !=null && val>next.val)
        {
            pre=next;
            next = next.next;
        }

        node.next =next;
        pre.next = node;
        return  root;


    }


}
