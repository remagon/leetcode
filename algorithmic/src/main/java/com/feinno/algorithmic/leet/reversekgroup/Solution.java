package com.feinno.algorithmic.leet.reversekgroup;


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
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (k <= 1 || head == null || head.next == null) {
    		return head;
    	}
        ListNode preNode = null;
        ListNode current = head;
        ListNode next = null;
        ListNode temp = null;
    	//ListNode 
        while (current != null) {
        	next = current;
        	
        	for (int i = 0; i < k - 1; i++) {
        		next = next.next;
        		if (next == null)
        			return head;
        	}
        	if (preNode == null) {
        		head = next;
        	} else {
        		preNode.next = next;
        	}
        	next = current.next;
        	if (preNode == null) {
            	current.next = head.next;
        	} else {
            	current.next = preNode.next.next;
        	}
        	preNode = current;
        	
        	for (int i = 0; i < k - 1; i++) {
        		temp = next.next;
        		next.next = current;
        		current = next;
        		next = temp;
        	}
        	current = preNode.next;
        }
        return head;
    }
    public static void main(String[] args) {
    	ListNode temp = new ListNode(1);
    	temp.next = new ListNode(2);
    	temp.next.next = new ListNode(3);
    	temp.next.next.next = new ListNode(4);
    	temp.next.next.next.next = new ListNode(5);
    	temp.next.next.next.next.next = new ListNode(6);
    	Solution sol = new Solution();
    	ListNode result = sol.reverseKGroup(temp, 3);
    	while (result != null) {
    		System.out.println(result.val);
    		result = result.next;
    	}
    }
}