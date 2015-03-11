package com.feinno.algorithmic.leet.removenthfromend;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null || n < 1)
    		return head;
    	ListNode a = head;
    	ListNode b = head;
    	ListNode pre = null;
    	while (a != null) {
    		if (n == 0) {
    			pre = b;
    			b = b.next;
    		} else {
    			n--;
    		}
    		a = a.next;
    	}
    	if (pre == null) {
    		return b.next;
    	}
    	pre.next = b.next;
    	return head;
    }
    
    public static void main(String[] args) {
    	ListNode temp = new ListNode(1);
    	temp.next = new ListNode(2);
    	temp.next.next = new ListNode(3);
    	temp.next.next.next = new ListNode(4);
    	temp.next.next.next.next = new ListNode(5);
    	Solution sol = new Solution();
    	ListNode result = sol.removeNthFromEnd(temp, 2);
    	while (result != null) {
    		System.out.println(result.val);
    		result = result.next;
    	}
    }
}