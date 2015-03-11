package com.feinno.algorithmic.leet.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author renzhaolong
 * 
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] num) {
    	Arrays.sort(num);
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	for (int i = 0; i < num.length - 2; i++) {
    		if (i > 0 && num[i] == num[i - 1]) {
    			continue;
    		}
    		int startid = i + 1;
    		int endid = num.length - 1;
    		int sum = -num[i];
    		while (startid < endid) {
    		    int temp = num[startid] + num[endid];
    			if (temp == sum) {
    				List<Integer> sum3 = new ArrayList<Integer>();
    				sum3.add(num[i]);
    				sum3.add(num[startid]);
    				sum3.add(num[endid]);
    				result.add(sum3);

    				startid++;
    				if (startid < 0 || startid >= num.length)
    					break;
    				while (num[startid] == num[startid - 1]) {
    					startid++;

        				if (startid < 0 || startid >= num.length)
        					break;
    				}
        			endid--;

    				if (endid < 0 || endid >= num.length)
    					break;
    				while (num[endid] == num[endid + 1]) {
            			endid--;

        				if (endid < 0 || endid >= num.length)
        					break;
    				}
    			} else if (temp < sum) {
    				startid++;
    			} else {
    				endid--;
    			}
    		}
    	}
    	return result;
    }
    public List<List<Integer>> threeSum1(int[] num) {
    	
    	Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < num.length - 1; i++) {
    		if (countMap.containsKey(num[i])) {
    			countMap.put(num[i], countMap.get(num[i]) + 1);
    		} else {
    			countMap.put(num[i], 1);
    		}
    	}
    	List<Integer> limitArr = new ArrayList<Integer>();
    	for (Integer value : countMap.keySet()) {
    		if (value == 0) {
    			int limit = countMap.get(value);
    			if (limit > 3)
    				limit = 3;
    			for (int i = 0; i < limit; i++) {
    				limitArr.add(value);
    			}
    		} else {
    			int limit = countMap.get(value);
    			if (limit > 2)
    				limit = 2;
    			for (int i = 0; i < limit; i++) {
    				limitArr.add(value);
    			}
    		}
    	}
    	Map<Integer, List<TwoNumber>> maps = new HashMap<Integer, List<TwoNumber>>();
    	Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
    	
        for (int i = 0; i < limitArr.size(); i++) {
        	int key = -limitArr.get(i);
        	if (maps.containsKey(key)) {
        		for (TwoNumber two : maps.get(key)) {
        			if (i > two.index2) {
        				List<Integer> three = new LinkedList<Integer>();
        				three.add(limitArr.get(i));
        				if (limitArr.get(two.index1) > limitArr.get(i)) {
        					three.add(limitArr.get(two.index1));
        				} else {
        					three.add(0, limitArr.get(two.index1));
        				}
        				for (int j = 0; j < three.size(); j++) {
        					if (three.get(j) > limitArr.get(two.index2)) {
        						three.add(j, limitArr.get(two.index2));
        						break;
        					}
        				}
        				if (three.size() == 2) {
        					three.add(limitArr.get(two.index2));
        				}
        				result.put(three.toString(), three);
        			}
        		}
        	}
        	for (int j = i + 1; j < limitArr.size(); j++){
        		if (i != j) {
        			int sum = limitArr.get(i) + limitArr.get(j);
        			//List<TwoNumber> numbers;
        			if (!maps.containsKey(sum)){
        				maps.put(sum, new LinkedList<TwoNumber>());
        			}
        			maps.get(sum).add(new TwoNumber(i, j));
        		}
        	}
        }
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        resultList.addAll(result.values());
        return resultList;
    }

    private static class TwoNumber {
    	public TwoNumber(int index1, int index2) {
    		this.index1 = index1;
    		this.index2 = index2;
    	}
    	private int index1;
    	private int index2;
    }
    
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.threeSum(new int[] {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6}));
		System.out.println(sol.threeSum(new int[] {0, 0, 0}));
	}

}