package com.feinno.algorithmic.leet.generateparenthesis;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	
    public List<String> generateParenthesis(int n) {
    	List<String> result = new LinkedList<String>();
    	generateParenthesisPart(result, "", 0, 0, n);
    	return result;
    }
    
    private void generateParenthesisPart(List<String> result, String s, int fontN, int backN, int all) {
    	if (fontN == all) {
    		for (int i = 0; i < backN; i++) {
    			s += ")";
    		}
    		result.add(s);
    		return;
    	}
    	generateParenthesisPart(result, s + "(", fontN + 1, backN + 1, all);
    	if (backN > 0) {
    		generateParenthesisPart(result, s + ")", fontN, backN - 1, all);
    	}
    }
    
    public static void main(String[] args) {

    	Solution sol = new Solution();
    	System.out.println(sol.generateParenthesis(3));
    }
}