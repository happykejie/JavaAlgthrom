package Algthrom40ti;

import java.util.*;
public class 二叉树的最大最小深度 {

    public  static  class TreeNode{
        int val =0;
        TreeNode left  =null;
        TreeNode right = null;
        public  TreeNode(int val){
            this.val = val;
        }
    }


    // 给定跟节点 求出BFS遍历二叉树的锅。
    public List<TreeNode> Bfs_tree(TreeNode root){
        Queue<TreeNode> myq = new LinkedList<>(); // 队列通过双向链表实现
        List<TreeNode> res = new ArrayList<>();
        if(root==null) return null;
        myq.add(root);
        while(!myq.isEmpty()){
            int len = myq.size();
            for(int i=0;i<len;i++){
                if(myq.peek().left!=null) myq.add(myq.peek().left); //加入左孩子
                if(myq.peek().right!=null) myq.add(myq.peek().right); //加入右孩子
                res.add(myq.poll());
            }
        }
        return res;
    }


    //Dfs遍历二叉树 先压栈柚子树 然后左子树
    public List<TreeNode> Dfs_tree(TreeNode root){
        Stack<TreeNode>  sta = new Stack<>();
        List<TreeNode> res = new ArrayList<>();
        if(root==null) return null;
        // res.add(root);
        sta.add(root);
        while(!sta.isEmpty()){
            TreeNode temp = sta.pop();
            res.add(temp);
            if(temp.right!=null) sta.push(temp.right);
            if(temp.left!=null) sta.push(temp.left);
        }
        return res;

    }
}
