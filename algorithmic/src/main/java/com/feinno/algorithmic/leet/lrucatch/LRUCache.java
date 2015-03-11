package com.feinno.algorithmic.leet.lrucatch;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
	private Map<Integer, Node> map = new HashMap<Integer, Node>();

	private int count;
	private int capacity;
	private Node last;
	private Node first;
	
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	this.count = 0;
    }
    
    public int get(int key) {
    	if (!map.containsKey(key))
    		return -1;
    	Node node = map.get(key);
    	setNodeToLast(node);
    	//if (node.next) 
		return node.value;
        
    }
    
    public void set(int key, int value) {
    	if (map.containsKey(key)) {
    		Node node = map.get(key);
    		node.value = value;
    		setNodeToLast(node);
    	} else {
    		if (count == capacity) {
    			map.remove(first.key);
    			first = first.next;
    			if (first != null) {
    				first.pre = null;
    			}
    			count--;
    		}
    		Node node = new Node();
    		node.key = key;
    		node.value = value;
    		setNodeToLast(node);
    		map.put(key, node);
    		count++;
    	}
    }
    
    private void setNodeToLast(Node node) {
    	removeNode(node);
    	if (last == null) {
    		first = last = node;
    		node.pre = null;
    		node.next = null;
    		return;
    	}
    	last.next = node;
    	node.pre = last;
    	node.next = null;
    	last = node;
    }
    
    private void removeNode(Node node) {
    	if (node == last) {
    		last = last.pre;
    		if (last == null) {
    			first = null;
    		} else {
    			last.next = null;
    		}
    		return;
    	}
    	if (node == first) {
    		first = first.next;
    		if (first == null) {
    			last = null;
    		} else {
        		first.pre = null;
    		}
    	}
    	if (node.pre != null) {
    		node.pre.next = node.next;
    	}
    	if (node.next != null) {
    		node.next.pre = node.pre;
    	}
    }
    
    private static class Node {
    	int key;
    	int value;
    	Node next;
    	Node pre;
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache(1);
    	cache.set(2,1);
    	cache.get(2);
    	cache.set(3,2);
    	cache.get(2);
    	cache.get(3);

//    	cache.set(10,13);  cache.set(3,17);  cache.set(6,11);  cache.set(10,5);  cache.set(9,10);  
//    	System.out.println(cache.get(13));  cache.set(2,19);  
//    	System.out.println(cache.get(2));  
//    	System.out.println(cache.get(3));  cache.set(5,25);  
//    	System.out.println(cache.get(8));  
//    	cache.set(9,22);  cache.set(5,5);  cache.set(1,30);  
//    	System.out.println(cache.get(11));  
//    	cache.set(9,12);  
//    	System.out.println(cache.get(7));  
//    	System.out.println(cache.get(5));  
//    	System.out.println(cache.get(8));  
//    	System.out.println(cache.get(9));  cache.set(4,30);  cache.set(9,3);  
//    	System.out.println(cache.get(9));  
//    	System.out.println(cache.get(10));  
//    	System.out.println(cache.get(10));  cache.set(6,14);  cache.set(3,1);  
//    	System.out.println(cache.get(3));  cache.set(10,11);  
//    	System.out.println(cache.get(8));  cache.set(2,14);  
//    	System.out.println(cache.get(1));  
//    	System.out.println(cache.get(5));  System.out.println(cache.get(4));
//    	cache.set(11,4);  
//    	cache.set(12,24);  
//    	cache.set(5,18);  
//    	System.out.println(cache.get(13));
//    	cache.set(7,23);  
//    	System.out.println(cache.get(8));
//    	System.out.println(cache.get(12));
//    	cache.set(3,27);  
//    	cache.set(2,12);  
//    	System.out.println(cache.get(5));
//    	cache.set(2,9);  
//    	cache.set(13,4);  
//    	cache.set(8,18);  
//    	cache.set(1,7);  
//    	System.out.println(cache.get(6));
//    	cache.set(9,29);  cache.set(8,21);  System.out.println(cache.get(5));
//    	cache.set(6,30);  cache.set(1,12);  System.out.println(cache.get(10));
//    	cache.set(4,15);  cache.set(7,22);  cache.set(11,26);  cache.set(8,17);  cache.set(9,29);  
//    	System.out.println(cache.get(5));  cache.set(3,4);  
//    	cache.set(11,30);  System.out.println(cache.get(12));  cache.set(4,29);  
//    	System.out.println(cache.get(3));
//    	System.out.println(cache.get(9));  
//    	System.out.println(cache.get(6));
//    	cache.set(3,4);  System.out.println(cache.get(1));
//    	System.out.println(cache.get(10));
//    	cache.set(3,29);  cache.set(10,28);  cache.set(1,20);  cache.set(11,13);  System.out.println(cache.get(3));
//    	cache.set(3,12);  cache.set(3,8);  cache.set(10,9);  cache.set(3,26);  System.out.println(cache.get(8));
//    	System.out.println(cache.get(7));
//    	System.out.println(cache.get(5));
//    	cache.set(13,17);  cache.set(2,27);  cache.set(11,15);  System.out.println(cache.get(12));
//    	cache.set(9,19);  cache.set(2,15);  cache.set(3,16);  System.out.println(cache.get(1));
//    	cache.set(12,17);  cache.set(9,1);  cache.set(6,19);  System.out.println(cache.get(4));  
//    	System.out.println(cache.get(5));  System.out.println(cache.get(5));  cache.set(8,1);  cache.set(11,7);  cache.set(5,2);  cache.set(9,28);  System.out.println(cache.get(1));
//    	cache.set(2,2);  cache.set(7,4);  cache.set(4,22);  cache.set(7,24);  cache.set(9,26);  cache.set(13,28);  cache.set(11,26);
    }
}