package com.feinno.algorithmic.leet.swappairs;

import java.util.LinkedList;
import java.util.List;


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
    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null)
    		return head;
    	ListNode preCurrent = null;
    	ListNode current = head;
        while (current != null) {
        	if (preCurrent == null) {
        		preCurrent = head.next;
        		head.next = preCurrent.next;
        		preCurrent.next = head;
        		head = preCurrent;
        		preCurrent = head.next;
        		continue;
        	}
        	if (preCurrent.next == null || preCurrent.next.next == null)
        		break;
        	current = preCurrent.next;
        	preCurrent.next = current.next;
        	current.next = current.next.next;
        	preCurrent.next.next = current;
        	preCurrent = current;
        }
        return head;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode node3 = new ListNode(1);
    	node3.next = new ListNode(2);
//    	node3.next.next = new ListNode(3);
//    	node3.next.next.next = new ListNode(4);
//    	node3.next.next.next.next = new ListNode(5);
    	ListNode result = sol.swapPairs(node3);
    	while (result != null) {
    	 System.out.println(result.val);
    	 result = result.next;
    	}
    }
}