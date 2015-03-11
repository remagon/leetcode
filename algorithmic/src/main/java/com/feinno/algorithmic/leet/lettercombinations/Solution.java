package com.feinno.algorithmic.leet.lettercombinations;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    String[] mapping = new String[] {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        addLetter(result, digits, 0, "");
        return result;
    }
    
    private void addLetter(List<String> result, String digits, int index, String pre) {
    	if (index == digits.length()) {
    		result.add(pre);
    		return;
    	}
    	int arrIndex = digits.charAt(index) - '0';
    	for (char ch : mapping[arrIndex].toCharArray()) {
    		addLetter(result, digits, index + 1, pre + ch);
    	}
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.letterCombinations("23"));
    }
}