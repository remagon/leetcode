package com.feinno.algorithmic.leet.longestvalidparentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 * For "(()", the longest valid parentheses substring is "()", which has length = 2.

 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * @author renzhaolong
 *
 */
public class Solution {
    public int longestValidParentheses(String s) {
    	if (null == s || 0 == s.length())
    		return 0;
    	int lenth = s.length();
    	int[] next = new int[lenth];
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '(') {
    			stack.push(i);
    		} else if (s.charAt(i) == ')') {
    			if (stack.size() != 0) {
    				int pos = stack.pop();
    				next[pos] = i + 1;
    			}
    		}
    	}
    	int result = 0;
    	int temp = 0;
    	int i = 0;
    	while (i < lenth) {
    		if (next[i] != 0) {
    			temp += next[i] - i;
    			i = next[i];
    		} else {
    			if (temp > result)
    				result = temp;
    			temp = 0;
    			i++;
    		}
    	}

		if (temp > result)
			result = temp;
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.longestValidParentheses("()"));
    }
}