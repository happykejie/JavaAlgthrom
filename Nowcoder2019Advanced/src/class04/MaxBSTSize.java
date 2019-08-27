package class04;




public class MaxBSTSize {

    public  static  class  Node{
        public  int value;
        Node left;
        Node right;
    }

    public  static  int maxBst(Node head)
    {
        return  process(head).maxBSTSize;
    }

    public  static class  Info{
        public  int maxBSTSize;
        public  boolean isBST;
        public  int min;
        public  int max;

        public Info(int maxBST, boolean is, int mi,int ma)
        {
            maxBSTSize = maxBST;
            isBST =is;
            min = mi;
            max = ma;
        }
    }

    public  static  Info process(Node X)
    {
        if(X == null) //base case
        {
            // x为空， isBST 为true不影响后续判断，  设置系统最大值和最小值也是如此，不用去判断左右是否为空。
            return  new Info(0,true,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);
        boolean isBST = false;
        int maxBSTSize = Math.max(leftInfo.maxBSTSize,rightInfo.maxBSTSize);//p1,p2

        if(leftInfo.isBST && rightInfo.isBST && leftInfo.max<X.value && rightInfo.min > X.value)
        {
            maxBSTSize = leftInfo.maxBSTSize +1+ rightInfo.maxBSTSize;
            isBST = true;
        }
        int min = Math.min(X.value, Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(X.value,Math.min(leftInfo.max,rightInfo.max));
        return  new Info(maxBSTSize,isBST,min,max);
    }
}
