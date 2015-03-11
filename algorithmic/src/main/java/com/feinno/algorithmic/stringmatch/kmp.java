package com.feinno.algorithmic.stringmatch;

public class kmp {
	public static int match(String source, String pattern) {
		int i = 0, j = 0;
		int[] next = getNext(pattern);
		while (i < source.length() && j < pattern.length()) {
			if (source.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else if (j == 0) {
				i++;
			}else {
				j = next[j];
			}
		}
		if (j >= pattern.length()) {
			return i - j;
		} else {
			return -1;
		}
	}
	
	private static int[] getNext(String pattern) {
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
		System.out.println(match("h", "h"));
	}
}
