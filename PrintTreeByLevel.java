package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//按行遍历二叉排序树
public class PrintTreeByLevel {
	private static Node tree;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("请输入数组长度:");
		int n = in.nextInt();
		System.out.print("请输入数组元素:");
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		BinaryTree(nums);//建树
		Node tt = tree;
		//inPrint(tt);//顺序打印
		//levelPrint(tt);//按层遍历
		//prePrint(tt);//非递归前序遍历
		//inOrder(tt);//非递归中序遍历
		postOrder(tt);//非递归后序遍历
	}
	
	public static void postOrder(Node root) {
		Deque<Node> deque = new ArrayDeque<>();
		Node p = null;
		while (root!=null||!deque.isEmpty()) {
			while (root!=null) {
				deque.addFirst(root);
				root = root.left;
			}
			if(!deque.isEmpty()){//栈不空
				root = deque.getFirst();//出栈
				if (root.right==null||root.right==p) {
					System.out.print(deque.removeFirst().data+" ");
					p = root;
					root = null;
				}else{
					root = root.right;
				}
			}
		}
	}
	
	public static void inOrder(Node root) {
		Deque<Node> deque = new ArrayDeque<>();//声明栈空间
		while (root!=null) {//让左线入栈
			deque.addFirst(root);
			root = root.left;
		}
		//依次出栈并判断是否有右子树
		while (!deque.isEmpty()) {//栈不空
			Node pNode = deque.removeFirst();//出栈
			System.out.print(pNode.data+" ");
			if (pNode.right!=null) {//出栈节点右子树不空
				Node qNode = pNode.right;//让新节点指向出栈节点的右子树的第一个节点
				while (qNode!=null) {//有子树不为空则继续入栈左线
					deque.addFirst(qNode);
					qNode = qNode.left;
				}
			}
		}
	}
	
	public static void prePrint(Node root) {
		Deque<Node> deque = new ArrayDeque<>();//声明栈空间
		deque.addFirst(root);
		while (!deque.isEmpty()) {//栈不空
			Node tempNode = deque.getFirst();
			System.out.print(deque.removeFirst().data+" ");
			if (tempNode.right!=null) {
				deque.addFirst(tempNode.right);
			}
			if (tempNode.left!=null) {
				deque.addFirst(tempNode.left);
			}
		}
	}
	
	public static void levelPrint(Node root) {
		Deque<Node> deque = new ArrayDeque<>();//声明一个队列，存储节点
		deque.addLast(root);
		while (!deque.isEmpty()) {//只要队列不为空
			if (deque.getFirst().left!=null) {
				deque.addLast(deque.getFirst().left);
			}
			if (deque.getFirst().right!=null) {
				deque.addLast(deque.getFirst().right);
			}
			System.out.print(deque.removeFirst().data+" ");
		}
	}
	
	public static void inPrint(Node root) {
		if (root!=null) {
			inPrint(root.left);
			System.out.print(root.data+" ");
			inPrint(root.right);
		}
	}
	
	public static void BinaryTree(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (tree == null) {//没有根结点
				tree = new Node(nums[i],null,null);
			}else{//说明有根节点了
				Node p = tree;
				Node q = p;
				while (p!=null){
					q = p;
					if (nums[i]<=p.data) {
						p = p.left;
					}else{
						p = p.right;
					}
				}
				if (nums[i]<=q.data) {
					q.left = new Node(nums[i], null, null);
				}else{
					q.right = new Node(nums[i], null, null);
				}
			}
		}
	}
	
	public static class Node{
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data,Node left,Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
