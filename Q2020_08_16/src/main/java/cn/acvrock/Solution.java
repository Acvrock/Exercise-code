package cn.acvrock;

import java.util.HashSet;

/**
 * Created by panjinghong on 2020/9/5.
 */


//https://leetcode-cn.com/problems/longest-palindrome/description/
class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
        System.out.println(longestPalindrome("aabcc"));
        System.out.println(longestPalindrome("aa1bcc"));


    }
    public static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 用于存放字符
        HashSet<Character> hashset = new HashSet<Character>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!hashset.contains(chars[i])) {// 如果hashset没有该字符就保存进去
                hashset.add(chars[i]);
            } else {// 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
                hashset.remove(chars[i]);
                count++;
            }
        }
        return hashset.isEmpty() ? count * 2 : count * 2 + 1;
    }
}