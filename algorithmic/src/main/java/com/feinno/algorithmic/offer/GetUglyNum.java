package com.feinno.algorithmic.offer;

public class GetUglyNum {
	public int getUglyByIndex(int index) {
		if (index <= 0)
			return 0;
		if (index == 1)
			return 1;
		int[] uglyArr = new int[index];
		uglyArr[0] = 1;
		int i = 1;
		int ugly2 = 0;
		int ugly5 = 0;
		int ugly3 = 0;
		while (i < index) {
			int curU2 = uglyArr[ugly2] * 2;
			int curU3 = uglyArr[ugly3] * 3;
			int curU5 = uglyArr[ugly5] * 5;
			if (curU2 < curU3 && curU2 < curU5) {
				ugly2++;
				if (uglyArr[i - 1] < curU2) {
					uglyArr[i] = curU2;
				} else {
					continue;
				}
			} else if (curU3 < curU5) {
				ugly3++;
				if (uglyArr[i - 1] < curU3) {
					uglyArr[i] = curU3;
				} else {
					continue;
				}
			} else {
				ugly5++;
				if (uglyArr[i - 1] < curU5) {
					uglyArr[i] = curU5;
				} else {
					continue;
				}
			}
			i++;
		}
		return uglyArr[index - 1];
	}
	

	public static void main(String[] args) {
		GetUglyNum solution = new GetUglyNum();
		System.out.println(solution.getUglyByIndex(7));
	}
}
