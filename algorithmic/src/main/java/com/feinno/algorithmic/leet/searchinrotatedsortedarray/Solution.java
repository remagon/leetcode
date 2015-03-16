package com.feinno.algorithmic.leet.searchinrotatedsortedarray;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * @author renzhaolong
 *
 */
public class Solution {
    public int search(int[] A, int target) {
        return binarySearch(A, 0, A.length - 1, target);
    }
    
    private int binarySearch(int[] A, int begin, int end, int target) {
		if (A[begin] == target)
			return begin;
		if (A[end] == target)
			return end;
		
    	if (end < begin)
    		return -1;
    	if (end - begin <= 1) {
    		return -1;
    	}
    	int mid = (begin + end) / 2;
    	if (target == A[mid])
    		return mid;
    	
    	if (A[begin] <= A[mid]) {
    		if (target < A[mid] && target > A[begin]) {
    			return binarySearch(A, begin + 1, mid - 1, target);
    		} else {
    			return binarySearch(A, mid + 1, end - 1, target);
    		}
    	} else {
    		if (target > A[mid] && target < A[begin]) {
    			return binarySearch(A, mid + 1, end - 1, target);
    		} else {
    			return binarySearch(A, begin + 1, mid - 1, target);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    	System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
    	System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
    	System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
    }
}