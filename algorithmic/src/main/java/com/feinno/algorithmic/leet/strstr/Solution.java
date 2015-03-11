package com.feinno.algorithmic.leet.strstr;

public class Solution {
    public int strStr1(String haystack, String needle) {
    	int gray = 29;
    	if (haystack == null || needle == null 
    			|| haystack.length() < needle.length()) {
    		return -1;
    	}
        int needleHash = 0;
        for (int i = 0; i < needle.length(); i++) {
        	needleHash = needle.charAt(i) + needleHash * 29;
        }
        int hHash = 0;
        for (int i = 0; i < needle.length(); i++) {
        	hHash = haystack.charAt(i) + hHash * 29;
        }
        boolean match = true;
        if (hHash == needleHash) {
    		for (int i = 0; i < needle.length(); i++) {
    			if (haystack.charAt(i) != needle.charAt(i)) {
    				match = false;
    				break;
    			}
    		}
    		if (match) {
    			return 0;
    		}
        }
        
        int maxHash = 1;
        for (int i = 1; i < needle.length(); i++) {
        	maxHash *= gray;
        }
        
        for (int i = needle.length(); i < haystack.length(); i++) {
        	hHash = (hHash - haystack.charAt(i - needle.length()) * maxHash) * gray + haystack.charAt(i);
        	if (hHash == needleHash) {
        		for (int j = 0; j < needle.length(); j++) {
        			if (needle.charAt(j) != haystack.charAt(i + j - needle.length() + 1)) {
        				match = false;
        				break;
        			}
        		}

        		if (match) {
        			return i- needle.length() + 1;
        		}
        	}
        }
        return -1;
    }
    
    public int strStr(String haystack, String needle) {
		int i = 0, j = 0;
		int[] next = getNext(needle);
		while (i < haystack.length() && j < needle.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else if (j == 0) {
				i++;
			}else {
				j = next[j];
			}
		}
		if (j >= needle.length()) {
			return i - j;
		} else {
			return -1;
		}
	}
	
	private int[] getNext(String pattern) {
		int[] result = new int[pattern.length()];
		int i = 1, j = 0;
		while (i < pattern.length() - 1) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
				result[i] = j;
			} else if (j == 0) {
				i++;
				result[i] = j;
			}else {
				j = result[j];
			}
		}
		return result;
	}
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.strStr("hw", "hw"));
    }
}