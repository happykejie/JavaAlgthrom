package CodingInterviewGuide;

public class 反转单链表 {

    public static  class  Node{
        public  int value; //数据域
        public  Node next; // 指针域
        public  Node(int data){
            this.value = data;
        }
    }

    public  Node reverseList(Node head){
        Node pre =null;
        Node next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return  pre;
    }

}
