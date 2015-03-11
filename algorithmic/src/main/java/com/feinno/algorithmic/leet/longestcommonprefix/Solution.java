package com.feinno.algorithmic.leet.longestcommonprefix;

/**
 * @author renzhaolong
 *
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0)
    		return "";
        int common = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
        	common = common < strs[i].length() ? common : strs[i].length();
        }
        for (int i = 1; i < strs.length; i++) {
        	common = getCommonPrefix(strs[0], strs[i], common);
        }
        return strs[0].substring(0, common);
    }
    
    private int getCommonPrefix(String str1, String str2, int compareLength) {
    	int common = 0;
    	for (; common < compareLength && common < str1.length() && common < str2.length(); common++) {
    		if (str1.charAt(common) != str2.charAt(common)) {
    			break;
    		}
    	}
    	return common;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.longestCommonPrefix(new String[] {"abc", "abcd", "a"}));
    }

}