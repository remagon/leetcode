package com.feinno.algorithmic.leet.wildcardmatching;

/**
 * 
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 * @author zhaolong.rzl
 *
 */
public class Solution {
	
    public boolean isMatch(String s, String p) {
    	if (s == p) {
    		return true;
    	}
    	if (s == null || p == null) {
    		return false;
    	}
        int len1 = s.length();  
        int len2 = p.length();
        if (len1 == 0 && len2 == 0) {
        	return true;
        }
        if (len1 == 0) {
        	for (int i = 0; i < len2; i++) {
        		if (p.charAt(i) != '*') {
        			return false;
        		}
        	}
        	return true;
        }
        if (len2 == 0) {
        	for (int i = 0; i < len1; i++) {
        		if (s.charAt(i) != '*') {
        			return false;
        		}
        	}
        	return true;
        }
        boolean[][] dif = new boolean[len1 + 1][len2 + 1];
        dif[0][0] = true;
        for (int i = 0; i < len2; i++) {
    		if (p.charAt(i) != '*') {
    			break;
    		}
    		dif[0][i + 1] = true;
    	}
        for (int i = 0; i < len1; i++) {
    		if (s.charAt(i) != '*') {
    			break;
    		}
    		dif[i + 1][0] = true;
    	}
        for (int i = 1; i < len1 + 1; i++) {
        	for (int j = 1; j < len2 + 1; j++) {
        		char c1 = s.charAt(i - 1);
        		char c2 = p.charAt(j - 1);
        		if (dif[i - 1][j - 1] == true) {
        			if (c1 == '*' || c1 == '?' || c2 == '*' || c2 == '?' || c1 == c2) {
        				dif[i][j] = true;
        				continue;
        			}
        		}
        		if (dif[i - 1][j] == true || dif[i][j - 1] == true) {
        			if (c2 == '*' || c1 == '*') {
        				dif[i][j] = true;
        				continue;
        			}
        		}
        	}
        }
        return dif[len1][len2];
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.isMatch("aa", "a"));
    	System.out.println(sol.isMatch("aa", "aa"));
    	System.out.println(sol.isMatch("aaa", "aa"));
    	System.out.println(sol.isMatch("aa", "*"));
    	System.out.println(sol.isMatch("aa", "a*"));
    	System.out.println(sol.isMatch("ab", "?*"));
    	System.out.println(sol.isMatch("c", "*?*"));
    }
}