package com.vaibhavmm.data_structures_and_alogrithms.two_pointers;

import java.util.Arrays;

/*

https://leetcode.com/problems/max-number-of-k-sum-pairs/description/
Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.

 */
public class MaxKSumPairs {

    public static void main(String[] args) {

        int[] nums = {3,1,3,4,3};
        int k = 6;
        System.out.println(maxOperations(nums, k));
    }

    public static int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);

        int i = 0, j = nums.length -1;
        int count = 0;

        while (i < j) {

            if (nums[i] + nums[j] == k) {
                count ++;
                j--;
                i ++;
            } else if (nums[i] + nums[j] > k) {
                j --;
            } else {
                i ++;
            }

        }

        return count;


    }


}
