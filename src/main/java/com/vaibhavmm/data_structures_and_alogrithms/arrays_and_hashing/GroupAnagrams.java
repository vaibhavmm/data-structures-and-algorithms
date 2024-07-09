package main.java.com.vaibhavmm.data_structures_and_alogrithms.arrays_and_hashing;

//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


//Example 1:
//
//        Input: strs = ["eat","tea","tan","ate","nat","bat"]
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//        Example 2:
//
//        Input: strs = [""]
//        Output: [[""]]
//        Example 3:
//
//        Input: strs = ["a"]
//        Output: [["a"]]


import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

        String[] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(s));


    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        // "eat" "tea" "bat" "apple" "fork" "ate" "two"

        Map<String, List<String>> collectAn = new HashMap<>();

        for (int i =0; i < strs.length; i ++) {
            char[] sChars = strs[i].toCharArray();
            Arrays.sort(sChars);


            List<String> getList = new ArrayList<>();
            if (collectAn.containsKey(Arrays.toString(sChars))) {
                getList = collectAn.get(Arrays.toString(sChars));
            }
            getList.add(strs[i]);
            collectAn.put(Arrays.toString(sChars), getList);
       }

        List<List<String>> result = new ArrayList<>(collectAn.values());
        result.sort(Comparator.comparingInt(List::size));
        return result;

    }






    public static List<List<String>> groupAnagrams_vm_costly_solution(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Set<Integer> indexSet = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            List<String> subResult = new ArrayList<>();

            if (!indexSet.contains(i)) {
                indexSet.add(0);
                subResult.add(strs[i]);
                for (int j = i + 1; j < strs.length ; j++) {

                    if ( !indexSet.contains(j) && isAnagram_costly_solution(strs[i], strs[j])) {
                        subResult.add(strs[j]);
                        indexSet.add(j);
                    }
                }
                result.add(subResult);
            }

        }
        result.sort(Comparator.comparingInt(List::size));
        return result;

    }

    public static boolean isAnagram_costly_solution(String orgText, String compareText) {

        Map<Character, Integer> charMap = new HashMap<>();

        for (Character c : orgText.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c,0) + 1);
        }

        for (Character t : compareText.toCharArray()) {
            if (charMap.containsKey(t)) {
                charMap.put(t, charMap.get(t) -1);
            } else {
                return false;
            }
        }

        return charMap.values().stream().noneMatch(x -> x!=0);

    }
}
