package com.feinno.algorithmic.leet.inttoroman;

/**
 * @author renzhaolong
 *
 */
public class Solution {
	
	private static class RomanValue {
		
		RomanValue(String romanValue, int intValue, boolean midValue) {
			this.romanValue = romanValue;
			this.intValue = intValue;
			this.midValue = midValue;
		}
		
		boolean midValue;
		String romanValue;
		int intValue;
	}
	
	private static RomanValue[] romans = 
			new RomanValue[] {new RomanValue("M", 1000, false),
				new RomanValue("D", 500, true),
				new RomanValue("C", 100, false),
				new RomanValue("L", 50, true),
				new RomanValue("X", 10, false),
				new RomanValue("V", 5, true),
				new RomanValue("I", 1, false)
			};
	
    public String intToRoman(int num) {
        if (num > 3999 || num < 1) {
        	return "out of range";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < romans.length; i += 2) {
        	int len = num / romans[i].intValue;
        	num = num % romans[i].intValue;
        	if (len == 9) {
        		result.append(romans[i].romanValue);
        		result.append(romans[i - 2].romanValue);
        	} else if (len > 5) {
    			result.append(romans[i - 1].romanValue);
        		for (int j = 5; j < len; j++) {
        			result.append(romans[i].romanValue);
        		}
        	} else if (len == 5) {
        		result.append(romans[i - 1].romanValue);
        	} else if (len == 4) {
        		result.append(romans[i].romanValue);
        		result.append(romans[i - 1].romanValue);
        	} else {
        		for (int j = 0; j < len; j++) {
        			result.append(romans[i].romanValue);
        		}
        	}
        }
        return result.toString();
    }
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.intToRoman(80).equals("LXXX"));
    	System.out.println(sol.intToRoman(400).equals("CD"));
    	System.out.println(sol.intToRoman(1997).equals("MCMXCVII"));
    	System.out.println(sol.intToRoman(2008).equals("MMVIII"));
    	System.out.println(sol.intToRoman(2016).equals("MMXVI"));
    	System.out.println(sol.intToRoman(19).equals("XIX"));
    	System.out.println(sol.intToRoman(5).equals("V"));
    	
    }

}