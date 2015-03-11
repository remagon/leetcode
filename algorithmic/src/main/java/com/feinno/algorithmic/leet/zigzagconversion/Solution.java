package com.feinno.algorithmic.leet.zigzagconversion;

/**
 * @author renzhaolong
 *
 */
public class Solution {
    public String convert(String s, int nRows) {
        if (nRows <= 1 || s == null) {
        	return s;
        }
        int loopNum = nRows + nRows - 2;
        int length = (s.length() / loopNum + 1) * 2;
        char[][] lines = new char[nRows][];
        for (int i = 0; i < lines.length; i++) {
        	lines[i] = new char[length];
        }
        int[] offset = new int[nRows];
        int pos = 0; 
        for (int i = 0; i < s.length(); i++) {
        	pos = i % loopNum;
        	if (pos < nRows) {
        		lines[pos][offset[pos]] = s.charAt(i);
        		offset[pos]++;
        	} else {
        		pos = loopNum - pos;
        		lines[pos][offset[pos]] = s.charAt(i);
        		offset[pos]++;
        	}
        }
        StringBuilder result = new StringBuilder(nRows + 1);
        for (int i = 0; i < lines.length; i++) {
        	result.append(lines[i], 0, offset[i]);
        }
        return result.toString();
        
    }

    public String convert2(String s, int nRows) {
        if (nRows <= 1 || s == null) {
        	return s;
        }
    	char[] result = new char[s.length()];
        int loopNum = nRows + nRows - 2;
        int len = s.length() / loopNum;
        int[] lengths = new int[nRows + 1];
    	for (int i = 1; i < nRows; i++) {
    		lengths[i] = len * 2;
    	}
    	lengths[1] = len;
    	lengths[nRows] = len;
    	int remainder = s.length() % loopNum;
    	for (int i = 0; i < remainder; i++) {
    		if (i < nRows) {
        		lengths[i + 1]++;
        	} else {
        		lengths[loopNum - i + 1]++;
        	}
    	}
    	for (int i = 1; i < nRows; i++) {
    		lengths[i] += lengths[i - 1];
    	}
        int[] offset = new int[nRows];
    	int pos = 0;
        for (int i = 0; i < s.length(); i++) {
        	pos = i % loopNum;
        	if (pos < nRows) {
        	} else {
        		pos = loopNum - pos;
        	}
    		result[lengths[pos] + offset[pos]] = s.charAt(i);
    		offset[pos]++;
        }
        return String.valueOf(result);
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.convert2("ABC", 3));
    }
}