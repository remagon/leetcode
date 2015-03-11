package com.feinno.algorithmic.leet.regularmatch;

/**
 * @author renzhaolong
 *
 */
public class Solution {
	
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }
    
    private boolean isMatch(String s, int startS, String p, int startP) {
    	while (s.length() > startS && p.length() > startP) {
    		if (p.length() - startP > 1 && p.charAt(startP + 1) == '*'){
    			if (s.charAt(startS) == p.charAt(startP) || p.charAt(startP) == '.') {
    				return (isMatch(s, startS, p, startP + 2)
    						|| isMatch(s, startS + 1, p, startP));
    			} else {
    				return isMatch(s, startS, p, startP + 2);
    			}
    		} else {
        		if (s.charAt(startS) == p.charAt(startP) || p.charAt(startP) == '.') {
        			startS++;
        			startP++;
        			continue;
        		} else {
        			return false;
        		}
    		}
    	}
    	if (startS == s.length() && (startP == p.length() || checkNull(p, startP))) {
    		return true;
    	}
    	return false;
    }
    
    private boolean checkNull(String p, int startP) {
    	if ((p.length() - startP) % 2 == 1)
    		return false;
    	for (int i = startP + 1; i < p.length(); i += 2) {
    		if (p.charAt(i) != '*') {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.isMatch("aa","a"));
    	System.out.println(sol.isMatch("aa","aa"));
    	System.out.println(sol.isMatch("aaa","aa"));
    	System.out.println(sol.isMatch("aa", "a*"));
    	System.out.println(sol.isMatch("aa", ".*"));
    	System.out.println(sol.isMatch("ab", ".*"));
    	System.out.println(sol.isMatch("aab", "c*a*b"));
    }

}