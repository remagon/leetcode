package com.feinno.algorithmic.leet.maxarea;

/**
 * @author renzhaolong
 * 
 */
public class Solution {

	public int maxArea(int[] height) {
		int maxArea = 0;
		int begin = 0;
		int end = height.length - 1;
		while (begin < end) {
			int hei = height[begin] < height[end] ? height[begin] : height[end];
			int area = hei * (end - begin);
			maxArea = maxArea > area ? maxArea : area;
			if (height[begin] < height[end]) {
				begin++;
			} else {
				end--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.maxArea(new int[] {2, 3, 4, 5,6}));
	}

}