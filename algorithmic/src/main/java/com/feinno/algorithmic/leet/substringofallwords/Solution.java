package com.feinno.algorithmic.leet.substringofallwords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
    	List<Integer> result = new ArrayList<Integer>();
    	int gray = 31;
    	if (S == null || L == null || L.length == 0
    			|| S.length() < L.length * L[0].length()) {
    		return result;
    	}
    	int patternLen = L[0].length();
    	int[] hashS = new int[S.length() - patternLen + 1];
        long lHash = 0;
        for (String elel : L) {
        	int eleHash = 0;
        	for (int i = 0; i < patternLen; i++) {
        		eleHash = elel.charAt(i) + eleHash * gray;
        	}
        	if (lHash == 0) {
        		lHash = eleHash;
        	} else {
        		lHash = eleHash + lHash;
        	}
        }
        hashS[0]  = 0;
        for (int i = 0; i < patternLen; i++) {
        	hashS[0] = S.charAt(i) + hashS[0] * gray;
        }
        
        int maxHash = 1;
        for (int i = 1; i < patternLen; i++) {
        	maxHash *= gray;
        }
        
        for (int i = 1; i <= S.length() - patternLen; i++) {
        	hashS[i] = (hashS[i - 1] - S.charAt(i - 1) * maxHash) * gray + S.charAt(i + patternLen - 1);
		}
                
        for (int i = 0; i < S.length(); i++) {
        	int last = (L.length - 1) * patternLen + i;
        	if (last >= hashS.length) {
        		break;
        	}
        	long currenthash = hashS[i];
        	for (int j = 1; j < L.length; j++) {
        		currenthash += hashS[i + j * patternLen];
        	}
        	if (currenthash == lHash) {
        		boolean match = true;
    			List<String> temp = new LinkedList<String>();
   			 
    			Collections.addAll(temp, L);
        		for (int j = 0; j < L.length; j++) {
        			String subStr = S.substring(i + j * patternLen, i + (j + 1) * patternLen);
        			boolean nomatch = true;
        			for (String l : temp) {
        				if (l.equals(subStr)) {
        					nomatch = false;
        					temp.remove(l);
        					break;
        				}
        			}
        			if (nomatch) {
        				match = false;
        				break;
        			}
        		}
        		if (match) {
        			result.add(i);
        		}
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.findSubstring("ababababab", new String[] {"ab", "ab", "ab", "ab"}));
    }
}