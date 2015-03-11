package com.feinno.algorithmic.leet.atoi;

/**
 * @author renzhaolong
 *
 */
public class Solution {
	
    public int atoi(String str) {
        str = str.trim();
        if (str.length() == 0)
        	return 0;
        int flag = 1;
        long result = 0L;
        int index = 0;
        for (; index < 1; index++) {
        	if (str.charAt(index) >= '0' && str.charAt(index) <= '9')
        		break;
        	if (str.charAt(index) == '-') {
        		flag *= -1;
        	} else if (str.charAt(index) == '+') {
        		
        	} else {
        		return 0;
        	}
        }

        for (; index < str.length(); index++) {
        	if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
        		result = result * 10 + (str.charAt(index) - '0');
        		if (result > Integer.MAX_VALUE) {
        			if (flag == 1) {
        				return Integer.MAX_VALUE; 
        			} else {
        				return Integer.MIN_VALUE;
        			}
        		}
        	} else {
        		break;
        	}
        }
        result *= flag;
        if (result > Integer.MAX_VALUE) {
        	return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
        	return Integer.MIN_VALUE;
        }
        return (int)result;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.atoi("9223372036854775809"));
    }

}