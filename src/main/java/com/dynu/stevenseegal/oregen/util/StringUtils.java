package com.dynu.stevenseegal.oregen.util;

public class StringUtils
{
    public static boolean isInteger(String str)
    {
        if (str == null)
        {
            return false;
        }
        int length = str.length();
        if (length == 0)
        {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-')
        {
            if (length == 1)
            {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++)
        {
            char c = str.charAt(i);
            if (c < '0' || c > '9')
            {
                return false;
            }
        }
        return true;
    }

    public static String toUpperCase(String str)
    {
        String returnStr = "";
        int strLength = str.length();
        if (strLength == 1)
        {
            returnStr = str.toUpperCase();
        }
        if (str.length() > 1)
        {
            returnStr = str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        return returnStr;
    }

    public static String stripModName(String str)
    {
        String returnStr = null;
        String[] s = str.split(":");
        if (s.length == 2)
        {
            returnStr = s[1];
        }
        return returnStr;
    }

    public static String stripPrefix(String str, int delimiter)
    {
        String returnStr = null;
        if (str.length() > delimiter)
        {
            returnStr = str.substring(delimiter);
        }
        return returnStr;
    }
}
