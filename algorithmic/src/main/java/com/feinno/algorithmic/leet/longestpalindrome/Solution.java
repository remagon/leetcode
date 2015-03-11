package com.feinno.algorithmic.leet.longestpalindrome;

/**
 * @author renzhaolong
 *
 */
public class Solution {
    public String longestPalindrome(String s) {
    	String result = ""; 
    	int beginIndex = 0;
    	int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
    		beginIndex = i;
    		endIndex = i;
        	for (; ; beginIndex--,endIndex++) {
        		if (beginIndex < 0 || endIndex >= s.length() || 
        				s.charAt(beginIndex) != s.charAt(endIndex)) {
        			if (result.length() < endIndex - beginIndex - 1) {
        				result = s.substring(beginIndex + 1, endIndex);
        			}
        			break;
        		}
        	}
        	if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
        		beginIndex = i;
        		endIndex = i + 1;
        		for (; ; beginIndex--,endIndex++) {
            		if (beginIndex < 0 || endIndex >= s.length() || 
            				s.charAt(beginIndex) != s.charAt(endIndex)) {
            			if (result.length() < endIndex - beginIndex - 1) {
            				result = s.substring(beginIndex + 1, endIndex);
            			}
            			break;
            		}
            	}
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.longestPalindrome("testtsastt"));
    }
}