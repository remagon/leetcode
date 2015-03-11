package com.feinno.algorithmic.leet.compareversion;

/**
 * @author renzhaolong
 *
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
    	while (version1.startsWith("0"))
    		version1 = version1.substring(1);
    	while (version2.startsWith("0"))
    		version2 = version2.substring(1);
        String[] verArr1 = version1.split("\\.0*");
        String[] verArr2 = version2.split("\\.0*");
        for (int i = 0; i < verArr1.length && i < verArr2.length; i++) {
        	if (verArr1[i].length() > verArr2[i].length()) {
        		return 1;
        	} else if (verArr1[i].length() < verArr2[i].length()) {
        		return -1;
        	}
        	int value = verArr1[i].compareTo(verArr2[i]);
        	if (value > 0) {
        		return 1;
        	} else if (value < 0) {
        		return -1;
        	}
        }
        if (verArr1.length > verArr2.length) {
        	return 1;
        } else if (verArr1.length < verArr2.length) {
        	return -1;
        }
        return 0;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.compareVersion("01.00.1","1.1.0"));
    	System.out.println(sol.compareVersion("01.10.1","1.1.0"));
    	System.out.println(sol.compareVersion("0.1","1.0"));
    	System.out.println(sol.compareVersion("1.0","1.1"));
    	System.out.println(sol.compareVersion("1.11","1.2"));
    	System.out.println(sol.compareVersion("1.2","13.16"));
    }
}