package com.vaibhavmm.data_structures_and_alogrithms.sliding_window;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/descriptiofn/

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        char[] charArr = s.toCharArray();
        Set<Character> resSet = new HashSet<>();
        int g = 0, start = 0;
        for (int i = 0; i < s.length() ; i++) {
            while (resSet.contains(charArr[i])) {
                resSet.remove(charArr[start]);
                start ++;
            }
            resSet.add(charArr[i]);
            g = Math.max(g, resSet.size());
        }
        return g;

    }
}
