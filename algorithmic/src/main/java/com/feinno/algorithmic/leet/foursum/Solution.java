package com.feinno.algorithmic.leet.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	Map<Integer, Position> map = new HashMap<Integer, Position>();
        for (int i = 0; i < num.length - 1; i++) {
        	for (int j = i + 1; j < num.length; j++) {
        		int[] poscurrent = new int[] {i, j};
        		int sum = num[i] + num[j];
        		int key = target - sum;
        		Position poss = map.get(key);
        		if (poss != null) {
        			for (int[] s : poss.positions) {
        				if (s[0] != i && s[0] != j && s[1] != i && s[1] != j) {
        					addIndex(result, new int[] {num[s[0]], num[s[1]], num[i], num[j]});
        				}
        			}
        		}
        		Position current = map.get(sum);
        		if (current == null) {
        			current = new Position();
        		}
        		current.positions.add(poscurrent);
        		map.put(sum, current);
        	}
        }

    	return result;
    }
    
    private void addIndex(List<List<Integer>> result, int[] key) {
    	Arrays.sort(key);
    	for (List<Integer> arr : result) {
        	boolean same = true;
    		for (int i = 0; i < arr.size(); i++) {
    			if (arr.get(i) != key[i]) {
    				same = false;
    				break;
    			}
    		}
    		if (same) {
    			return;
    		}
    	}
    	List<Integer> data = new LinkedList<Integer>();
    	for (int i = 0; i < key.length; i++) {
    		data.add(key[i]);
    	}
    	result.add(data);
    }
    
    private static class Position {
    	private List<int[]> positions = new LinkedList<int[]>();
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
    }
}