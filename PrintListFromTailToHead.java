package jianzhioffer;

import java.awt.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

import javax.security.auth.login.FailedLoginException;

class ListNode{
	private Integer data;
	private ListNode next;
	
	public ListNode(){
		
	}
	
	public ListNode(Integer data,ListNode next) {
		this.data = data;
		this.next = next;
	}

	public Integer getData() {
		return data;
	}
	
	public void setData(Integer data) {
		this.data = data;
	}
	
	public ListNode getNext() {
		return next;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public String toString() {
		return "data="+data+"\n"+"next="+next;
	}
}

public class PrintListFromTailToHead {
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] shuzu = new int[5];
		for (int i = 0; i < shuzu.length; i++) {
			shuzu[i] = in.nextInt();
		}
		ListNode head = null,tail = null;
		for (int i = 0; i < shuzu.length; i++) {
			ListNode node = new ListNode(shuzu[i],null);
			if (head == null) {
				head = tail = node;
			}else{
				tail.setNext(node);
				tail = tail.getNext();
			}
		}
		System.out.println(printListFromTailToHead(head));
	}
	
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Deque<Integer> queue = new ArrayDeque<Integer>();
		for (ListNode p = listNode; p != null; p = p.getNext()) {
			queue.addFirst(p.getData());
		}
		while (!queue.isEmpty()) {
			arrayList.add(queue.pop());
		}
        return arrayList;
    }
}
