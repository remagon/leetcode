package com.feinno.algorithmic.leet.searchinsertposition;

public class Solution {
    public int searchInsert(int[] A, int target) {
        return binarySearch(A, target, 0, A.length - 1);
    }
    
    private int binarySearch(int[] A, int target, int begin, int end) {
    	if (end < begin) {
    		return end + 1;
    	}
    	if (begin == end) {
    		if (A[end] < target) {
    			return end + 1;
    		} 
    		return end;
    	}
    	int mid = (begin + end) / 2;
    	if (A[mid] == target) {
    		return mid;
    	}
    	if (A[mid] > target) {
    		return binarySearch(A, target, begin, mid - 1);
    	}
    	return binarySearch(A, target, mid + 1, end);
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.searchInsert(new int[] {1}, 1));
    	System.out.println(sol.searchInsert(new int[] {1,3,5,6}, 5));
    	System.out.println(sol.searchInsert(new int[] {1,3,5,6}, 2));
    	System.out.println(sol.searchInsert(new int[] {1,3,5,6}, 7));
    	System.out.println(sol.searchInsert(new int[] {1,3,5,6}, 0));
    }
}