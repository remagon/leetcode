package com.feinno.algorithmic;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String reg = "[\u007f-\u009f]|\u00ad|[\u0483-\u0489]|[\u0559-\u055a]|\u058a|[\u0591-\u05bd]|\u05bf|[\u05c1-\u05c2]|[\u05c4-\u05c7]|[\u0606-\u060a]|[\u063b-\u063f]|\u0674|[\u06e5-\u06e6]|\u070f|[\u076e-\u077f]|\u0a51|\u0a75|\u0b44|[\u0b62-\u0b63]|[\u0c62-\u0c63]|[\u0ce2-\u0ce3]|[\u0d62-\u0d63]|\u135f|[\u200b-\u200f]|[\u2028-\u202e]|\u2044|\u2071|[\uf701-\uf70e]|[\uf710-\uf71a]|\ufb1e|[\ufc5e-\ufc62]|\ufeff|\ufffc";
        String s = "abc\u2028d";
        try {
            Pattern pat = Pattern.compile(reg);
            Matcher mat = pat.matcher(s);
            while (mat.find()) {
                String temp = mat.group();
                s = s.replace(mat.group(), " ");
            }
            System.out.println(s);
            byte[] buffer = s.getBytes("UTF-8");
            for (byte b : buffer) {
                System.out.println( Integer.toHexString(b));
            }
        } catch (UnsupportedEncodingException e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
