package com.feinno.algorithmic.offer;

public class MaxSumSubArr {
	public int getMaxSum(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int sum[] = new int[arr.length];
		sum[0] = arr[0];
		int max = sum[0];
		
		for (int i = 1; i < arr.length; i++) {
			sum[i] = sum[i - 1] > 0 ? sum[i - 1] + arr[i] : arr[i];
			if (sum[i] > max) {
				max = sum[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaxSumSubArr solution = new MaxSumSubArr();
		System.out.println(solution.getMaxSum(new int[]{-1,2,3}));
	}
}
