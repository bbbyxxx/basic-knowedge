package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//���б�������������
public class PrintTreeByLevel {
	private static Node tree;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("���������鳤��:");
		int n = in.nextInt();
		System.out.print("����������Ԫ��:");
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		BinaryTree(nums);//����
		Node tt = tree;
		//inPrint(tt);//˳���ӡ
		//levelPrint(tt);//�������
		//prePrint(tt);//�ǵݹ�ǰ�����
		//inOrder(tt);//�ǵݹ��������
		postOrder(tt);//�ǵݹ�������
	}
	
	public static void postOrder(Node root) {
		Deque<Node> deque = new ArrayDeque<>();
		Node p = null;
		while (root!=null||!deque.isEmpty()) {
			while (root!=null) {
				deque.addFirst(root);
				root = root.left;
			}
			if(!deque.isEmpty()){//ջ����
				root = deque.getFirst();//��ջ
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
		Deque<Node> deque = new ArrayDeque<>();//����ջ�ռ�
		while (root!=null) {//��������ջ
			deque.addFirst(root);
			root = root.left;
		}
		//���γ�ջ���ж��Ƿ���������
		while (!deque.isEmpty()) {//ջ����
			Node pNode = deque.removeFirst();//��ջ
			System.out.print(pNode.data+" ");
			if (pNode.right!=null) {//��ջ�ڵ�����������
				Node qNode = pNode.right;//���½ڵ�ָ���ջ�ڵ���������ĵ�һ���ڵ�
				while (qNode!=null) {//��������Ϊ���������ջ����
					deque.addFirst(qNode);
					qNode = qNode.left;
				}
			}
		}
	}
	
	public static void prePrint(Node root) {
		Deque<Node> deque = new ArrayDeque<>();//����ջ�ռ�
		deque.addFirst(root);
		while (!deque.isEmpty()) {//ջ����
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
		Deque<Node> deque = new ArrayDeque<>();//����һ�����У��洢�ڵ�
		deque.addLast(root);
		while (!deque.isEmpty()) {//ֻҪ���в�Ϊ��
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
			if (tree == null) {//û�и����
				tree = new Node(nums[i],null,null);
			}else{//˵���и��ڵ���
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
