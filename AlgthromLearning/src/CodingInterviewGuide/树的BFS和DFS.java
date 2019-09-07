package CodingInterviewGuide;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 树的BFS和DFS {

    public  static  void  main(String[] args){

    }

    /*树的广度搜索算法*/
    public  static  void TreeBFS(TreeNode root){
        if(root ==null)
        {
            return;
        }
        Queue<TreeNode> qt = new LinkedList<TreeNode>();
        ArrayList<Integer> nodes = new ArrayList<>();
        qt.offer(root);
        //便利循环树
        while(!qt.isEmpty()){

            if(qt.peek().left != null){qt.offer(qt.peek().left);}
            if(qt.peek().right != null){qt.offer(qt.peek().right);}
            nodes.add(qt.poll().val); // 弹出父节点，并加入数组
        }

    }

//   树的深度搜索算法-非递归 ——线序遍历
    public  static  void TreeDFS(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> nodes = new ArrayList<>();

        st.push(root);
        while (!st.isEmpty()){
            TreeNode tree = st.pop();
            //先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
            if(tree.right!=null)
                st.push(tree.right);
            if(tree.left!=null)
                st.push(tree.left);
            nodes.add(tree.val);

        }
    }

    //深度优先递归实现-先序遍历

    public  static  void TreeDFSRecursive(TreeNode root){

        if(root != null){

            System.out.println(root.val+" ,");
            TreeDFSRecursive(root.left);
            TreeDFSRecursive(root.right);
        }
    }



}
