package BATAlgthromInterView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 按层次打印二叉树 {

    public static   class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static class TreePrinter {

        public int[][] printTree(TreeNode root) {
            // write code here
            //Arraylist 数组列表，可以动态扩容，默认初始化10size
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> list = new ArrayList<>();

            if(root == null)
            {
                return  null;
            }

            // LinkedList java 的链表结构 ， 由于LinkedList 类实现了Queue 接口，因此我们可以把Linkedlist 当前Queue来用
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            TreeNode last = root;
            TreeNode nlast = null;
            while (!q.isEmpty()){
                TreeNode cur = q.poll();
                list.add(cur.val);

                if(cur.left !=null)
                {
                    q.offer(cur.left);
                    nlast = cur.left;
                }
                if(cur.right != null){
                    q.offer(cur.right);
                    nlast = cur.right;
                }
                if(cur==last)
                {
                    res.add(list);
                    list = new ArrayList<>();
                    last = nlast;
                }
            }

            int[][] result = new int[res.size()][];
            for(int i=0; i<res.size();i++){
                result[i] = new int[res.get(i).size()];
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = res.get(i).get(j);
                }
            }
            return result;




        }
    }





}


