package com.feinno.algorithmic.leet.addtwonumbers;

/**
 * @author renzhaolong
 *
 */
public class Solution {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int value = 0;
    	int bit = 0;
    	ListNode result = new ListNode(0);
    	ListNode lastNode = result;
        while (true) {
        	if (l1 == null && l2 == null && bit == 0) {
        		break;
        	}
        	value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + bit;
        	if (value >= 10) {
        		value -= 10;
        		bit = 1;
        	} else {
        		bit = 0;
        	}
        	ListNode currentNode = new ListNode(value);
        	lastNode.next = currentNode;
        	lastNode = currentNode;
        	l1 = l1 != null ? l1.next : null;
        	l2 = l2 != null ? l2.next : null;
        }
        return result.next;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode l1 = new ListNode(7);
//    	l1.next = new ListNode(5);
//    	l1.next.next = new ListNode(5);
    	ListNode l2 = new ListNode(3);
//    	l2.next = new ListNode(5);
//    	l2.next.next = new ListNode(3);
    	ListNode result = sol.addTwoNumbers(l1, l2);
    	while (result != null) {
    		System.out.println(result.val);
    		result = result.next;
    	}
    }
}