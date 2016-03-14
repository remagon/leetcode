package com.feinno.algorithmic.leet.countandsay;

public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String result = "1";
        if (n == 1)
            return result;
        while (n > 1) {
            result = getNext(result);
            n--;
        }
        return result;
    }
    
    private String getNext(String strn) {

        StringBuffer result = new StringBuffer();
        int count = 1;
        char last = strn.charAt(0);
        for (int i = 1; i < strn.length(); i++) {
            if (last == strn.charAt(i)) {
                count++;
            } else {
                result.append(count);
                result.append(last);
                count = 1;
                last = strn.charAt(i);
            }
        }

        result.append(count);
        result.append(last);
        return result.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countAndSay(3));
    }
}