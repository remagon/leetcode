package com.feinno.algorithmic.leet.nextpermutation;

public class Solution {
    public void nextPermutation(int[] num) {
        for (int i = num.length - 1; i > 0; i--) {
        	if (num[i - 1] < num[i]) {
        		int j = i;
        		for (; j < num.length - 1; j++) {
        			if (num[i - 1] >= num[j + 1]) {
        				break;
        			}
        		}
        		swap(num, i - 1, j);
        		reverseArr(num, i, num.length - 1);
        		return;
        	}
        }
        reverseArr(num, 0, num.length - 1);
    }
    
    private void reverseArr(int[] num, int b, int e) {
    	for (int i = b; i <= e; i++) {
    		int last = e + b - i;
    		if (last <= i)
    			break;
    		swap(num, i, last);
    	}
    }
    
    private void swap(int[] num, int b, int e) {
		int temp = num[b];
		num[b] = num[e];
		num[e] = temp;
    }
    /*
     * 1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
     */
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] arr = new int[] {1,2,3};
    	sol.nextPermutation(arr);
    	printarr(arr);
    	arr = new int[] {3,2,1};
    	sol.nextPermutation(arr);
    	printarr(arr);
    	arr = new int[] {1,1,5};
    	sol.nextPermutation(arr);
    	printarr(arr);
    	arr = new int[] {1,4,5, 4, 3};
    	sol.nextPermutation(arr);
    	printarr(arr);
    }
    
    private static void printarr(int[] arr) {
    	for (int value : arr) {
    		System.out.print(value);
    		System.out.print("  ");
    	}
    	System.out.println();
    }
}