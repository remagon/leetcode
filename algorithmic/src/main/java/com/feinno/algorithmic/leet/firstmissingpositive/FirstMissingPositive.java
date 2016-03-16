
package com.feinno.algorithmic.leet.firstmissingpositive;


/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * Subscribe to see which companies asked this question
 * date: 2016年3月16日 下午6:03:28 <br/>
 *
 * @author renzhaolong
 * 
 */
public class FirstMissingPositive {
    
    public int firstMissingPositive(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int pos = nums.length;
        while (pos > 0) {
            int temp = nums[pos - 1];
            if (temp <= 0) {
                pos--;
            } else if (temp < pos) {
                if (nums[temp - 1] == temp) {
                    pos--;
                } else {
                    nums[pos - 1] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            } else {
                pos--;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    
    public static void main(String[] args) {
        FirstMissingPositive instance = new FirstMissingPositive();
        System.out.println(instance.firstMissingPositive(new int[] {1, 1}));
    }
}

