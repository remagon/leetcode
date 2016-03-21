
package com.feinno.algorithmic.leet.multiplystrings;


/**
 * 
 * date: 2016年3月18日 下午7:39:50 <br/>
 *
 * @author renzhaolong
 * 
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int pos = 1;
        int num1len = num1.length();
        int num2len = num2.length();
        if (num1.startsWith("-")) {
            pos *= -1;
            num1len -= 1;
        } else if (num1.startsWith("+")) {
            num1len -= 1;
        }
        if (num2.startsWith("-")) {
            pos *= -1;
            num2len -= 1;
        } else if (num2.startsWith("+")) {
            num2len -= 1;
        }
        int[] num1Arr = new int[num1len];
        int[] num2Arr = new int[num2len];
        for (int i = 0; i < num1len; i++) {
            num1Arr[i] = num1.charAt(num1.length() - 1 - i) - '0';
        }

        for (int i = 0; i < num2len; i++) {
            num2Arr[i] = num2.charAt(num2.length() - 1 - i) - '0';
        }
        int[] resultArr = new int[num1len + num2len];
        for (int i = 0; i < num1len; i++) {
            for (int j = 0; j < num2len; j++) {
                resultArr[i + j] += num1Arr[i] * num2Arr[j];
            }
        }
        String result = "";
        for (int i = 0; i < resultArr.length; i++) {
            result = (resultArr[i] % 10) + result;
            int jinwei = resultArr[i] / 10;
            if (jinwei > 0) {
                resultArr[i + 1] = resultArr[i + 1] + jinwei;
            }
        }
        while (result.startsWith("0") && result.length() > 1) {
            result = result.substring(1);
        }
        if (pos == -1 && !result.equals("0")) {
            result = "-" + result;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        MultiplyStrings mul = new MultiplyStrings();
        System.out.println(mul.multiply("-119", "0"));
    }
}

