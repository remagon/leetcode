package com.feinno.algorithmic.leet.palindrome;

/**
 * @author renzhaolong
 *
 */
public class Solution {
	
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        long y = 0;
        int p = x;
        while (p > 0) {
        	y = y * 10 + p % 10;
        	p = p / 10;
        	if (y > Integer.MAX_VALUE)
        		return false;
        }
        if (y - x == 0)
        	return true;
        return false;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.isPalindrome(1222111222));
    }

}