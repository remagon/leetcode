package com.feinno.algorithmic.leet.romantoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @author renzhaolong
 *
 */
public class Solution {
		
//	private static RomanValue[] romans = 
//			new RomanValue[] {new RomanValue("M", 1000, false),
//				new RomanValue("D", 500, true),
//				new RomanValue("C", 100, false),
//				new RomanValue("L", 50, true),
//				new RomanValue("X", 10, false),
//				new RomanValue("V", 5, true),
//				new RomanValue("I", 1, false)
//			};
	private static Map<Character, Integer> romans = new HashMap<Character, Integer>();
	
	static {
		romans.put('M', 1000);
		romans.put('D', 500);
		romans.put('C', 100);
		romans.put('L', 50);
		romans.put('X', 10);
		romans.put('V', 5);
		romans.put('I', 1);
	}
	
    public int romanToInt(String s) {
    	int result = 0;
        for (int i = 0; i < s.length(); ) {
        	if (i + 1 < s.length() && romans.get(s.charAt(i)) < romans.get(s.charAt(i + 1))) {
        		result += romans.get(s.charAt(i + 1)) - romans.get(s.charAt(i));
        		i += 2;
        	} else {
        		result += romans.get(s.charAt(i));
        		i++;
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.romanToInt("LXXX")== 80);
    	System.out.println(sol.romanToInt("CD")== 400);
    	System.out.println(sol.romanToInt("MCMXCVII") == 1997);
    	System.out.println(sol.romanToInt("MMVIII") == 2008);
    	System.out.println(sol.romanToInt("MMXVI") == 2016);
    	System.out.println(sol.romanToInt("XIX") == 19);
    	System.out.println(sol.romanToInt("V") == 5);
    	System.out.println(sol.romanToInt("MCMXCVI") == 1996);
    	
    }

}