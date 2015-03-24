package com.feinno.algorithmic.leet.mergetwolists;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		ListNode currentNode = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				currentNode.next = l1;
				currentNode = currentNode.next;
				l1 = l1.next;
			} else {
				currentNode.next = l2;
				currentNode = currentNode.next;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			currentNode.next = l1;
		}
		if (l2 != null) {
			currentNode.next = l2;
		}
		return head;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode node3 = new ListNode(-8);
		node3.next = new ListNode(-7);
		node3.next.next = new ListNode(-7);
		ListNode node1 = new ListNode(-2);
		node1.next = new ListNode(5);
		node1.next.next = new ListNode(8);
		ListNode node2 = new ListNode(-10);
		node2.next = new ListNode(-10);
		node2.next.next = new ListNode(-7);
		ListNode node4 = new ListNode(2);
		ListNode result = sol.mergeTwoLists(node2, node4);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
