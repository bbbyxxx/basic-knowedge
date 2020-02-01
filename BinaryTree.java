package tree;
//二叉排序树/二叉查找树
public class BinaryTree {
	private static Node tree;
	public static void main(String[] args) {
		addData(3);
		addData(2);
		addData(5);
		addData(3);
		addData(4);
		addData(4);
		addData(3);
		addData(4);
		addData(1);
		addData(4);
		Node pNode = tree;
		inPrint(pNode);
		System.out.println();
		System.out.println(searchData(3));
		deleteData(4);
		inPrint(tree);
	}
	
	//添加数据到二叉查找树（即构建二叉查找树）
	public static void addData(int data){
		if (tree==null) {//tree==null，说明是根结点
			tree = new Node(data,null,null);
		}else{//说明已经有根结点了
			Node p = tree;
			Node q = p;
			while(p!=null){
				q=p;
				if (data<=p.data) {
					p = p.left;
				}else if (data>p.data) {
					p = p.right;
				}
			}
			if (data<=q.data) {
				q.left = new Node(data,null,null);
			}else{
				q.right = new Node(data,null,null);
			}
		}
	}
	
	//中序遍历排序二叉树，输出排序列表
	public static void inPrint(Node tree) {
		if (tree!=null) {
			inPrint(tree.left);
			System.out.print(tree.data+" ");
			inPrint(tree.right);
		}
	}
	
	//查找指定元素
	public static boolean searchData(int data) {
		Node trees = tree;
		while (true) {
			while(trees!=null&&data<trees.data) {
				trees = trees.left;
				if (trees!=null&&trees.data == data) {
					return true;
				}
			}
				
			while(trees!=null&&data>=trees.data){
				trees = trees.right;
				if (trees!=null&&trees.data == data) {
					return true;
				}
			}
			
			if (trees == null) {
				return false;
			}
		}
	}
	
	//删除指定元素
	public static void deleteData(int data) {
		Node p = tree;
		Node q = p;
		while (true) {
			while (p.data!=data){//定位data的位置
				q = p;
				if (data < p.data) {
					p = p.left;
				}else{
					p = p.right;
				}
				if (p == null) {
					return ;
				}
			}
			//做删除操作
			if (p.left==null||p.right==null) {//情况一：左子树或者右子树为空或者删除的正好是p结点
				if (p.left == null) {
					if (q.left == p) {
						q.left = p.right;
					}else if (q.right == p) {
						q.right = p.right;
					}
					p.right = null;
				}
				if (p.right == null) {
					if (q.left == p) {
						q.left = p.left;
					}else if (q.right == p) {
						q.right = p.left;
					}
					p.left = null;
				}
				break;
			}else{//情况二：左子树和右子树均不为空
				Node tt = p.right;
				Node kk = p;
				while (tt.left!=null) {
					kk = tt;
					tt = tt.left;
				}
				p.data = tt.data;
				kk.left = null;
				break;
			}
		}
	}
}

class Node{
	public int data;
	public Node left;
	public Node right;
	
	public Node(int data) {
		this.data = data;
	}
	
	public Node(int data,Node left,Node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}