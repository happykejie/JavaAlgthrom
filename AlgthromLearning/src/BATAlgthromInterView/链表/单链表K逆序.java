package BATAlgthromInterView.链表;

import java.util.*;

public class 单链表K逆序 {

    public  static  void main(String[] args){

        int[] arr ={1,2,3,4,5,6,7,8};

        //构造链表头节点
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;

        for(int i =1; i<arr.length;i++){
            //生成新的节点
            ListNode newhead = new ListNode(arr[i]);
            cur.next =newhead;
            cur = cur.next;
        }



        ListNode link= inverse(head,3);

        for(int i =1; i<arr.length;i++){
            //生成新的节点
            System.out.println(link.val+", ");
            link = link.next;
        }
    }

    public static ListNode inverse(ListNode head, int k) {
        // write code here
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        //此时cur为第k+1个节点
        if (count == k) {
            cur = inverse(cur,k);
            // 下面这个图展示了节点指向的顺序. 每次将头结点放置在cur节点之前。
            // head   	tmp		     	      cur
            // [ 1 ] -> [ 2 ] -> .. [ n ] -> [ y ] -> ...
            // cur
            // [ 1 ] -> [ y ] -> ...
            // head
            // [ 2 ] -> .. -> [ n ]
            while(count-- >0) { // 没看懂
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            //cur为翻转后的第一个节点
            head = cur;
        }
        return head;
    }

    // 利用栈实现功能
    public static   ListNode reverseNodes1(ListNode head, int k){
        if(k<2){
            return  head;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode  newhead = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur !=null){
            next = cur.next;
            stack.push(cur);
            if(stack.size() == k){
                pre = resign1(stack,pre,next);
                newhead = newhead == head?cur:newhead;
            }
            cur= next;
        }
        return  newhead;
    }

    public static   ListNode resign1(Stack<ListNode> stack,ListNode left, ListNode right){

        ListNode cur = stack.pop();
        if(left != null){
            left.next =cur;
        }

        ListNode next = null;
        while (!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return  cur;

    }
}
