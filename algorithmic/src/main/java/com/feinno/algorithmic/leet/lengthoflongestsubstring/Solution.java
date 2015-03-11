package com.feinno.algorithmic.leet.lengthoflongestsubstring;

/**
 * @author renzhaolong
 * 
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		java.util.Map<Character, Integer> map = new java.util.HashMap<Character, Integer>();
		char[] chars = s.toCharArray();
		int result = 0, begin = 0, end = 0, currentLen = 0;
		for (;;) {
			if (!map.containsKey(chars[end])) {
				currentLen++;
			} else {
				int index = map.get(chars[end]);
				if (index >= begin) {
					result = result > currentLen ? result : currentLen;
					begin = index + 1;
					currentLen = end - begin + 1;
				} else {
					currentLen++;
				}
			}
			map.put(chars[end], end);
			end++;
			if (end >= chars.length) {
				result = result > currentLen ? result : currentLen;
				return result;
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.lengthOfLongestSubstring("bbbbab"));
	}
}