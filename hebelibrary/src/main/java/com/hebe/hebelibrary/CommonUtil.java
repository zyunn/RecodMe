package com.hebe.hebelibrary;

/**
 * 一般Util
 * Greate By HebeChung on 2016/9/29
 */
public class CommonUtil {
    /**
     * 将helloWorld转hello_world.
     */
    public static String getSplitString(String input) {
        StringBuffer str = new StringBuffer();
        if (input != null) {
            for (int i = 0; i < input.length(); i++) {
                char a = input.charAt(i);
                if ((a >= 'A') && (a <= 'Z')) {
                    a += 32;
                    if (i != 0) {
                        str.append("_");
                    }
                }
                str.append(a);
            }
        }
        return str.toString();
    }

} 
