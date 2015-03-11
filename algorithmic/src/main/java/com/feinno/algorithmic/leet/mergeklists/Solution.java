package com.feinno.algorithmic.leet.mergeklists;

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
    public ListNode mergeKLists(List<ListNode> lists) {
    	if (lists.size() == 0) {
    		return null;
    	}
    	Node[] arr = new Node[lists.size()];
    	int len = 0;
        for (int i = 0; i < lists.size(); i++) {
        	ListNode node = lists.get(i);
        	if (node != null) {
        		pushHeap(arr, new Node(node, i), len);
        		len++;
        	}
        	lists.set(i, node.next);
        }
        ListNode result = null;
        ListNode current = null;
        while (len > 0) {
	        Node minNode = popHeap(arr, len);
	        len--;
	        ListNode next = minNode.val;
	        if (current == null) {
	        	result = next;
	        } else {
	        	current.next = next;
	        	next.next = null;
	        }
        	current = next;
	    	ListNode node = lists.get(minNode.idx);
	    	if (node != null) {
	    		pushHeap(arr, new Node(node, minNode.idx), len);
	    		len++;
	        	lists.set(minNode.idx, node.next);
	    	}
        }
    	return result;
    }
    
    private void pushHeap(Node[] arr, Node node, int lenth) {
    	arr[lenth] = node;
    	int curIndex = lenth;
    	while (lenth > 0) {
    		int parentIndex = (curIndex - 1) / 2;
    		Node parentNode = arr[parentIndex];
        	if (node.val.val < parentNode.val.val) {
        		swapArr(arr, parentIndex, curIndex);
        		curIndex = parentIndex;
        	} else {
        		break;
        	}
    	}
    }
    
    private Node popHeap(Node[] arr, int lenth) {
    	Node result = arr[0];
    	arr[0] = arr[lenth - 1];
    	lenth = lenth - 1;
    	int curIndex = 0;
    	
    	while (curIndex < lenth) {
    		int childIndex1 = curIndex * 2 + 1;
    		int childIndex2 = curIndex * 2 + 2;
    		if (childIndex1 > lenth - 1) {
    			break;
    		}
    		if (childIndex2 < lenth && arr[childIndex2].val.val < arr[childIndex1].val.val) {
    			childIndex1 = childIndex2;
    		}
    		if (arr[curIndex].val.val > arr[childIndex1].val.val) {
    			swapArr(arr, childIndex1, curIndex); 
    		}
    		curIndex = childIndex1;
    	}
    	return result;
    }
    
    private void swapArr(Node[] arr, int pos1, int pos2) {
    	Node temp = arr[pos1];
    	arr[pos1] = arr[pos2];
    	arr[pos2] = temp;
    }
    
    private static class Node {
    	ListNode val;
    	int idx;
    	
    	public Node(ListNode value, int index) {
    		this.val = value;
    		this.idx = index;
    	}
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
    	List<ListNode> pa = new LinkedList<ListNode>();
    	pa.add(node2);
    	pa.add(node1);
    	pa.add(node3);
    	pa.add(node4);
    	ListNode result = sol.mergeKLists(pa);
    	while (result != null) {
    	 System.out.println(result.val);
    	 result = result.next;
    	}
    }
}