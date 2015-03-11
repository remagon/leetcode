package com.feinno.algorithmic.leet.reverseint;

/**
 * @author renzhaolong
 *
 */
public class Solution {
	
    public int reverse(int x) {
    	String numStr = String.valueOf(x);
    	char[] reverse = new char[numStr.length()];
    	int index = 0;
    	int srcIndex = numStr.length() - 1;
    	if (numStr.charAt(0) == '-') {
    		reverse[index++] = '-';
    	}
    	while (index < reverse.length) {
    		reverse[index++] = numStr.charAt(srcIndex--);
    	}
    	long value = Long.parseLong(String.valueOf(reverse));
    	if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
    		return 0;
    	}
    	return (int)value;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.reverse(1000000003));
    }

}