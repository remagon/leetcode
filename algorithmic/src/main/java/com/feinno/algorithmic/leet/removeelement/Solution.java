package com.feinno.algorithmic.leet.removeelement;


public class Solution {
    public int removeElement(int[] A, int elem) {
        int lastIndex = A.length - 1;
        for (int i = 0; i <= lastIndex; ) {
        	if (A[i] == elem) {
        		A[i] = A[lastIndex];
        		lastIndex--;
        	} else {
        		i++;
        	}
        }
        return lastIndex + 1;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] A = new int[] {0, 1, 3, 3, 3, 3};
    	System.out.println(sol.removeElement(A, 3));
    	System.out.println(A);
    	
    }
}