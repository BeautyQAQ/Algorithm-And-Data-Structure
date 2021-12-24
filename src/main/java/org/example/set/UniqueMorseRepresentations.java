package org.example.set;

import java.util.HashSet;
import java.util.Set;

/**
 * No.804 唯一摩尔斯密码词
 * 
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * 
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 */
public class UniqueMorseRepresentations {
    /**
     * java标准HashSet实现
     * @param words 单词数组
     * @return 摩斯密码数量
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(codes[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    /**
     * BSTSet 实现
     * @param words 单词数组
     * @return 摩斯密码数量
     */
    public int uniqueMorseRepresentationsBSTSet(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        BSTSet<String> set = new BSTSet<>();
        for(String word: words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);

            set.add(res.toString());
        }

        return set.getSize();
    }

        /**
     * BSTSet 实现
     * @param words 单词数组
     * @return 摩斯密码数量
     */
    public int uniqueMorseRepresentationsLinkedListSet(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        LinkedListSet<String> set = new LinkedListSet<>();
        for(String word: words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);

            set.add(res.toString());
        }

        return set.getSize();
    }

    public static void main(String[] args) {
        String[] str = {"gin","zen","gig","msg"};
        UniqueMorseRepresentations object = new UniqueMorseRepresentations();
        int i1 = object.uniqueMorseRepresentations(str);
        int i2 = object.uniqueMorseRepresentationsBSTSet(str);
        int i3 = object.uniqueMorseRepresentationsLinkedListSet(str);
        System.out.println("i1="+i1+", i2="+i2+",i3="+i3);
    }
}
