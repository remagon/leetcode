package com.feinno.algorithmic.leet.findmediansortedarrays;

/**
 * @author renzhaolong
 *
 */
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
    	if (A == null || A.length == 0)
    		return getMedianSortedArrays(null, 0, 0, B, 0, B.length - 1);
    	if (B == null || B.length == 0)
    		return getMedianSortedArrays(A, 0, A.length - 1, null, 0, 0);
    	
    	//if (A.length < 2 || B.length < 2)
    	if (A.length > B.length) {
    		int[] temp = B;
    		B = A;
    		A = temp;
    	}
    	
    	if (B.length < 6)
    		return getMedianSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1);
    	
    	int middleA = A.length / 2;
    	int beginA = middleA - 1 > 0 ? middleA - 1 : 0;
    	int endA = 0; 
    	if (A.length % 2 == 1) {
    		endA = middleA + 1 < A.length ? middleA + 1 : A.length - 1;
    	} else {
    		endA = middleA;
    	}
    	
    	int middleB = B.length / 2;
    	int beginB = middleB - 1 > 0 ? middleB - 1 : 0;
    	int endB = 0; 
    	if (B.length % 2 == 1) {
    		endB = middleB + 1 < B.length ? middleB + 1 : B.length - 1;
    	} else {
    		endB = middleB;
    	}
    	
    	if (A[0] > B[endB + beginA]) {
    		int tempbegin = 0;
    		int tempend = endA - beginA;
    		while (tempend >= tempbegin) {
    			if (A[0] <= B[endB + beginA]) {
    				return getMedianSortedArrays(A, tempbegin, tempend, B, beginB + beginA, endB + beginA);
    			}
    			endB++;
    			tempend--;
    		}
    		int d = (A.length + B.length) / 2;

        	if ((A.length + B.length) % 2 == 0) {
        		if (d < B.length) {
        			return ((double)B[d - 1] + B[d]) / 2;
        		} else {
        			return ((double)A[0] + B[d - 1]) / 2;
        		}
        	} else {
        		return B[d];
        	}
    	}
    	
    	if (A[A.length - 1] < B[beginB - beginA]) {

    		int tempend = A.length - 1;
    		int tempbegin = tempend - endA + beginA;
    		while (tempend >= tempbegin) {
    			if (A[A.length - 1] >= B[beginB - beginA]) {
    				return getMedianSortedArrays(A, tempbegin, tempend, B, beginB - beginA, endB - beginA);
    			}
    			beginB--;
    			tempbegin++;
    		}
    		
    		int d = (A.length + B.length) / 2 - A.length;

        	if ((A.length + B.length) % 2 == 0) {
        		if (d - 1 >= 0) {
        			return ((double)B[d - 1] + B[d]) / 2;
        		} else {
        			return ((double)A[A.length - 1] + B[d]) / 2;
        		}
        	} else {
        		return B[d];
        	}
    	}
    	int scopeBegin = 0;
    	int scopeEnd = A.length - 1;
        int step = 0;
    	
        while (true) {
        	if (A[beginA] <= B[endB] && A[endA] >= B[beginB]) {
        		return getMedianSortedArrays(A, beginA, endA, B, beginB, endB);
        	} else if (A[beginA] > B[endB]) {
        		step = (beginA - scopeBegin) / 2 + 1;
        		if (step < 1)
        			break;
        		scopeEnd = beginA - 1;
        		beginA -= step;
        		endA -= step;
        		beginB += step;
        		endB += step;
        	} else {
        		step = (scopeEnd - endA) / 2 + 1;
        		if (step < 1)
        			break;
        		scopeBegin = endA + 1;
        		beginA += step;
        		endA += step;
        		beginB -= step;
        		endB -= step;
        	}
        }
        return 0;
    }
    
    private double getMedianSortedArrays(int A[], int beginIndexA, int endIndexA, int B[], int beginIndexB, int endIndexB) {
    	int[] newArr;
    	int begin = 0;
    	int end = 0;
    	if (A == null) {
    		newArr = B;
    		begin = beginIndexB;
    		end = endIndexB + 1;
    	} else if (B == null) {
    		newArr = A;
    		begin = beginIndexA;
    		end = endIndexA + 1;
    	} else {
	    	newArr = new int[endIndexB + endIndexA - beginIndexA - beginIndexB + 2];
	    	int index = 0;
	    	while (beginIndexA <= endIndexA && beginIndexB <= endIndexB) {
	    		if (A[beginIndexA] < B[beginIndexB]) {
	    			newArr[index] = A[beginIndexA];
	    			beginIndexA++;
	    		} else {
	    			newArr[index] = B[beginIndexB];
	    			beginIndexB++;    			
	    		}
				index++;
	    	}
	    	for (; beginIndexA <= endIndexA; beginIndexA++) {
				newArr[index] = A[beginIndexA];
				index++;
	    	}
	    	for (; beginIndexB <= endIndexB; beginIndexB++) {
				newArr[index] = B[beginIndexB];
				index++;
	    	}
	    	end = newArr.length;
    	}
    	int d = begin + (end - begin) / 2;
    	if ((end - begin) % 2 == 0) {
    		return ((double)newArr[d - 1] + newArr[d]) / 2;
    	} else {
    		return newArr[d];
    	}
    }

    public double test2(int[] A, int[] B) {
//    	if (A.length > B.length) {
//    		int[] temp = B;
//    		B = A;
//    		A = temp;
//    	}
//    	if ()
    	return 0.0;
    }
    public static void main(String[] args) {
    	Solution sol = new Solution();
//    	int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//    	int[] B = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16};[1,2,3,5], [4,6,7,8,9,10]
    	int[] A = new int[] {1, 2, 3};
    	int[] B = new int[]{8,9,10};
    	System.out.print(sol.test2(A, B));
    }
}