package com.vaibhavmm.data_structures_and_alogrithms.arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

/*
Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []
 */
public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }


    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        int range = nums.length;

        for (int n : nums) {
            n = Math.abs(n);

            if (nums[range - n] > 0) {
                nums[range - n] *= -1;
            } else {
               res.add(n);
            }
        }
        return res;
    }
}
