
package com.feinno.algorithmic.leet.combinationsum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * Subscribe to see which companies asked this question
 *
 * @author renzhaolong
 * 
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, candidates.length, target);
    }
    
    private List<List<Integer>> combinationSum2(int[] candidates, int length, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        for (int i = length; i > 0; i--) {
            int candidate = candidates[i - 1];
            if (i != length && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (candidate > target) {
                continue;
            }
            List<List<Integer>> midResult = combinationSum2(candidates, i - 1, target - candidate);
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
        CombinationSum2 sum = new CombinationSum2();
        List<List<Integer>> result = sum.combinationSum2(new int[] { 10,1,2,7,6,1,5 }, 8);
        for (List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

