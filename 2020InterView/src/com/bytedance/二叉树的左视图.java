package com.bytedance;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class 二叉树的左视图 {

    public  static  class  TreeNode{
        public  int value;
        public  TreeNode left;
        public  TreeNode right;
        public  TreeNode(int data){
            this.value =data;
        }

    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        rightSideView1(root, list, 0);
        return list;
    }
    public void rightSideView1(TreeNode root, List<Integer> list ,int level) {
        if (root == null) {
            return;
        }

        if (level == list.size()) {
            list.add(root.value);
        }
        rightSideView1(root.right,list,level+1); // 先打印右边
        rightSideView1(root.left,list,level + 1); // 如果这层右边边没有，再找左边有没有

    }


    public List<Integer> leftSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        leftSideView1(root, list, 0);
        return list;
    }
    public void leftSideView1(TreeNode root, List<Integer> list ,int level) {
        if (root == null) {
            return;
        }

        if (level == list.size()) {
            list.add(root.value);
        }
        leftSideView1(root.left,list,level + 1); // 先打印最左边
        leftSideView1(root.right,list,level+1); // 如果这层左边没有，再找右边有没有


    }


    //左视图
    public List<Integer> LeftSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean first = false;
            //对每一行操作
            while(size > 0) {

                TreeNode current = queue.poll();

                if (current.left!=null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

                size --;
                //表示只添加没一行的第一个
                if (!first) {
                    result.add(current.value);
                    first= true;
                }

            }
        }
        return result;
    }


    // 一层一层遍历

    public List<Integer> rightSideView3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            //对每一行操作
            while(size > 0) {

                TreeNode current = queue.poll();

                if (current.left!=null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

                size --;
                //表示是每一行的最后一个
                if (size == 0) {
                    result.add(current.value);
                }

            }
        }
        return result;
    }
}
