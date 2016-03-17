
package com.feinno.algorithmic.leet.trappingrainwater;


/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * 
 * Subscribe to see which companies asked this question
 * 
 * date: 2016年3月17日 下午7:47:01 <br/>
 *
 * @author renzhaolong
 * 
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        return trap(0, height.length - 1, height);
    }
    
    private int trap(int begin, int end, int[] height) {
        int result = 0;
        if (end - begin <= 0) {
            return result;
        }
        if (height[begin] > height[end]) {
            int horizontal = height[end];
            while (end > begin) {
                end--;
                if (horizontal < height[end]) {
                    return result + trap(begin, end, height);
                } else {
                    result += horizontal - height[end];
                }
            }
        } else {
            int horizontal = height[begin];
            while (end > begin) {
                begin++;
                if (horizontal < height[begin]) {
                    return result + trap(begin, end, height);
                } else {
                    result += horizontal - height[begin];
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        TrappingRainWater trap = new TrappingRainWater();
        System.out.println(trap.trap(new int[] {2,0,2}));
    }
}

