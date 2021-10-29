package org.example.leetCode;

/**
 * No.14 最长公共前缀
 */
public class LongestCommonPrefix{
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        int length = strs.length;
        String prefix = strs[0];
        for(int i=0; i<length; i++){
            prefix = calPrefix(prefix,strs[i]);
            if(prefix.length()==0){
                return prefix;
            }
        }
        return prefix;
    }

    public String calPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        for(int i=0;i<length;i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                break;    
            }
            index++;
        }
        return str1.substring(0,index);
    }
}
