package com.feinno.algorithmic.leet.searchrange;

public class Solution {
	private int min = -1;
	private int max = -1;
	public int[] searchRange(int[] A, int target) {
		if (A == null) {
			return new int[]{-1, -1};
		}
		min = A.length;
		binarySearch(A, 0, A.length - 1, target);
		if (max >= 0) {
			return new int[]{min, max};
		}
		
		return new int[]{-1, -1};
	}
	
	private void binarySearch(int[] A, int begin, int end, int value) {
		if (begin > end)
			return;
		int mid = (begin + end) / 2;
		
		if (A[mid] == value) {
			if (max < mid) {
				max = mid;
			}
			if (min > mid) {
				min = mid;
			}
			binarySearch(A, mid + 1, end, value);
			binarySearch(A, begin, mid - 1, value);
		} else if (A[mid] > value) {
			binarySearch(A, begin, mid - 1, value);
		} else {
			binarySearch(A, mid + 1, end, value);
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] result = sol.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8);
		for (int i : result) {
			System.out.println(i);
		}
	}
}