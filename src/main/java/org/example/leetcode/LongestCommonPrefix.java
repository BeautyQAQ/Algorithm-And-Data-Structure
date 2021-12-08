package org.example.leetcode;

/**
 * No.14 最长公共前缀
 */
public class LongestCommonPrefix{
    
    /**
     * 横向扫描
     * @param strs strs
     * @return String
     */
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
    
    /**
     * 纵向扫描
     * @param strs strs
     * @return String
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs==null||strs.length==0){
            return "";
        }
        // 纵向扫描: 遍历第一个字符串的字符,并与其余字符串响应的位置比较
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i==strs[j].length()||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
