package com.feinno.algorithmic.leet.validparenttheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '(' || c == '[' || c == '{') {
        		stack.push(c);
        	} else {
        		if (stack.size() == 0)
        			return false;
        		char pre = stack.pop();
        		if ( pre == '(' && c == ')')
        			continue;
        		if ( pre == '[' && c == ']')
        			continue;
        		if ( pre == '{' && c == '}')
        			continue;
        		return false;
        	}
        }
        if (stack.size() > 0)
        	return false;
        return true;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.isValid("()()()(){}"));
    	System.out.println(sol.isValid("()()((){})"));
    	System.out.println(sol.isValid(")()((){})"));
    }
}