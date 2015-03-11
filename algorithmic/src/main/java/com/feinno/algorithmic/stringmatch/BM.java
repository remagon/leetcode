package com.feinno.algorithmic.stringmatch;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * Boyer-Moore算法
 * 
 * @author renzhaolong
 *
 */
public class BM {

	public int match(String source, String pattern) {
		int sLen = source.length();
		int pLen = pattern.length();
		if (pLen > sLen) 
			return - 1;
		int[] bmGs = new int[pattern.length()];
		preBmGs(pattern, bmGs);
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		preBmBc(pattern, map);
		int m = pLen - 1;
		while (m < sLen) {
			int i = m;
			for (; i > m - pLen; i--) {
				if (source.charAt(i) != pattern.charAt(m - i + pLen - 1)) {
					break;
				}
			}
			if (i == m - pLen) {
				return i + 1;
			} else {
				int pPos = pLen + i - m - 1;
				int nextPos = Math.min(map.get(source.charAt(pPos)), bmGs[pPos]);
				m += i - nextPos;
			}
		}
		return -1;
	}
	
	private void suffix(String pattern, int[] suffix) {
		int q = 0;
		int ptLength = pattern.length();
		for (int i = ptLength - 2; i >= 0; i--) {
			q = i;
			while (q >= 0
					&& pattern.charAt(q) == pattern.charAt(ptLength - 1 - i
							+ q)) {
				if (suffix[ptLength - 1 - i + q] == 0) {
					suffix[ptLength - 1 - i + q] = i;
				}
				q--;
			}
		}
	}

	private void preBmGs(String pattern, int[] bmGs) {
		int i, j;
		int ptLength = pattern.length();
		//int[] suffix = new int[patLength];
		suffix(pattern, bmGs);
		
		//int[] preGs = new int[ptLength];
		
		for (i = 0; i < ptLength - 1; i++) {
			boolean match = true;
				
			for (j = 0; j < i; j++) {
				if (pattern.charAt(j) != pattern.charAt(j + ptLength - i - 1)) {
					match = false;
					break;
				}
			}
			if (match) {
				for (j = i; j < ptLength; j++) {
					if (bmGs[ptLength - 1 - j] == 0)
						bmGs[ptLength - 1 - j] = i;
				}
			}
		}

		System.out.print("bmGs:");
		for (i = 0; i < ptLength; i++) {
			System.out.print(bmGs[i] + ",");
		}
		System.out.println();
	}

	private void preBmBc(String pattern, Map<Character, Integer> map) {
		for (int i = pattern.length() - 1; i > 0; i--) {
			if (!map.containsKey(pattern.charAt(i))) {
				map.put(pattern.charAt(i), i);
			}
		}
	}
	
	public static void main(String[] args) {
		BM bm = new BM();
		String pattern = "abcdabcabc";
		System.out.println(bm.match("ababcdabcabc", pattern));// (pattern, new int[pattern.length()]);
	}
}
