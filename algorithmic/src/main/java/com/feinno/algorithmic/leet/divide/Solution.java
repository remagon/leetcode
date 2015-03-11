package com.feinno.algorithmic.leet.divide;

public class Solution {
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (divisor == 1) {
			return dividend;
		}
		if (divisor == -1) {
			return -dividend;
		}
		
		if (dividend > 0 && divisor < 0) {
			if (-dividend > divisor)
				return 0;
			return -getDivideNeg(dividend, -divisor);
		}
		if (dividend > 0 && divisor > 0) {
			if (-dividend > -divisor)
				return 0;
			return getDivideNeg(dividend, divisor);
		}
		if (dividend < 0 && divisor < 0) {
			if (dividend > divisor)
				return 0;
			return getDivideNeg(divisor - dividend, -divisor) + 1;
		}
		if (dividend < 0 && divisor > 0) {
			if (dividend > -divisor)
				return 0;
			return -getDivideNeg(-divisor - dividend, divisor) - 1;
		}
		return 0;
	}
	
	public int getDivideNeg(long dividend, long divisor) {
		if (dividend == 0)
			return 0;
		int result = 0;
		while (dividend >= divisor) {
			int bit = 1;
			long temp = divisor;
			while (temp <= dividend) {
				dividend -= temp;
				result += bit;
				temp <<= 1;
				bit <<= 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
	}
}