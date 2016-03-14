
package com.feinno.algorithmic.leet.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * Subscribe to see which companies asked this question
 *  
 * date: 2016年3月8日 下午6:27:23 <br/>
 *
 * @author renzhaolong
 * 
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, candidates.length, target);
    }
    
    private List<List<Integer>> combinationSum(int[] candidates, int length, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        for (int i = length; i > 0; i--) {
            int candidate = candidates[i - 1];
            if (candidate > target) {
                continue;
            }
            List<List<Integer>> midResult = combinationSum(candidates, i, target - candidate);
            if (midResult != null && midResult.size() > 0) {
                for (List<Integer> list : midResult) {
                    list.add(candidate);
                    result.add(list);
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        List<List<Integer>> result = sum.combinationSum(new int[] { 2, 3, 6, 7 }, 7);
        for (List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

