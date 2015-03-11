package com.feinno.algorithmic.leet.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author renzhaolong
 *
 */
public class Solution {
	
	public int[] twoSum2(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
    	int[] result = new int[2];
		
		for (int i = 0; i < numbers.length; i++) {
			int other = target - numbers[i];
			if (map.containsKey(other)) {
				result[0] = map.get(other) + 1;
				result[1] = i + 1;
				return result;
			} else {
				map.put(numbers[i], i);
			}
		}
		return null;
	}
	
    public int[] twoSum(int[] numbers, int target) {
    	int[] newCol = numbers.clone();
    	sort(newCol);
    	int[] result = new int[2];
    	for (int i = 0; i < newCol.length - 1; i++) {
    		for (int j = i + 1; j < newCol.length; j++) {
    			if (newCol[i] + newCol[j] == target) {
    				for (int m = 0; m < numbers.length; m++) {
    					if (numbers[m] == newCol[i] || numbers[m] == newCol[j]) {
    						if (result[0] == 0) {
    							result[0] = m + 1;
    						} else if (result[1] == 0) {
    							result[1] = m + 1;
    							return result;
    						}
    					}
    				}
    				return null;
    			} else if (newCol[i] + newCol[j] > target) {
    				break;
    			}
    		}
    	}
    	return null;
    }
    
	private void sort(int[] arr) {
		int step = arr.length / 2;
		while (step > 0){
			for (int i = 0; i < step; i++){
				insertSort(arr, i, step);
			}
			step = (int)((double)step / 2);
		}
	}
	
	private void insertSort(int[] arr, int startNo, int step){
		int temp;
		for (int i = startNo + step; i < arr.length; i += step){
			for (int j = i; j > 0; j -= step){
				if (j - step < 0){
					break;
				}
				if (arr[j] < arr[j - step]){
					temp = arr[j];
					arr[j] = arr[j - step];
					arr[j - step] = temp;
				} else{
					break;
				}
			}
		}
	}
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] numbers= new int[]{0, 4, 3, 0};
    	int target = 0;
    	int[] result = sol.twoSum2(numbers, target);
    	System.out.println(String.format("Output: index1=%d, index2=%d", result[0], result[1]));
    }
}