package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import tree.PrintTreeByLevel.Node;

//��������һЩ����
public class PracticeTree {
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
			inPrint(tt);//����ݹ����������
			System.out.println();
			System.out.println(countLeaf(tt));//��Ҷ�ӽڵ�ĸ���
			System.out.println(countParent(tt));//��˫�׽ڵ�ĸ���
			System.out.println(countLevel(tt));//�����
			MirriorTree(tt);//������
			inPrint(tt);
		}
		
		public static void MirriorTree(Node root) {
			if (root!=null) {
				Node temp = root.left;
				root.left = root.right;
				root.right = temp;
				MirriorTree(root.left);
				MirriorTree(root.right);
			}
		}

		public static int countLevel(Node root) {
			if (root==null) {
				return 0;
			}else{
				int l1 = countLevel(root.left);
				int l2 = countLevel(root.right);
				return l1>l2?l1+1:l2+1;
			}
		}
		
		public static int countParent(Node root) {
			if (root == null) {
				return 0;
			}else{
				int l1 = countParent(root.left);
				int l2 = countParent(root.right);
				if (root.left!=null&&root.right!=null) {
						return l1+l2+1;
				}else{
						return l1+l2;
				 }
			}
		}
		
		public static int countLeaf(Node root) {
			if (root==null) {
				return 0;
			}else{
				int l1 = countLeaf(root.left); 
				int l2 = countLeaf(root.right);
				if (root.left==null&&root.right==null) {
					return l1+l2+1;
				}else {
					return l1+l2;
				}
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
