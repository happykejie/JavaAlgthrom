package BATAlgthromInterView.链表;

import java.util.ArrayList;

public class 打印两个链表公共部分 {

    public  static  void main(String[] args){

    }

    public int[] findCommonParts(ListNode headA, ListNode headB) {
        // write code here
        //动态数组
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (headA != null && headB != null) {
            //等于一起走
            if (headA.val == headB.val) {
                list.add(headA.val);
                headA = headA.next;
                headB = headB.next;

            } else if (headA.val < headB.val) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
