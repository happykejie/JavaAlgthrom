package class05;

import java.util.LinkedList;

public class Code05_IsCBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	// 判断是否是完全二叉树
	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		LinkedList<Node> queue = new LinkedList<>();
		boolean leaf = false;
		Node l = null;
		Node r = null;
		queue.add(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			// 叶子节点，后面的左右孩子都必须是空， 左节点没有，右节点也必须没有，否则不是完全二叉树
			if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
				return false;
			}
			if (l != null) {
				queue.add(l);
			}
			if (r != null) {
				queue.add(r);
			}
			if(l==null || r== null)
			{
				leaf = true; //发现叶子节点，后面的都应该是叶子节点才满足
			}
		}
		return true;
	}

}
