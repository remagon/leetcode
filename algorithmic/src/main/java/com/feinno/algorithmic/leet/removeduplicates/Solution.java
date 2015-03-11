package com.feinno.algorithmic.leet.removeduplicates;

public class Solution {
    public int removeDuplicates(int[] A) {
    	if (A == null || A.length == 0)
    		return 0;
    	if (A.length == 1)
    		return 1;
    	int index = 1;
    	for (int i = 1; i < A.length; i++) {
    		if (A[i] != A[i - 1]) {
    			A[index] = A[i];
    			index++;
    		}
    	}
    	return index;
    }
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] A = new int[] {0, 1, 3, 3, 3, 3, 4, 4, 4, 4};
    	System.out.println(sol.removeDuplicates(A));
    	System.out.println(A);
    	
    }
}