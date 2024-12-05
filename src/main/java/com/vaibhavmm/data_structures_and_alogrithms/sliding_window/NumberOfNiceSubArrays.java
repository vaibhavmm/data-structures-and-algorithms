package com.vaibhavmm.data_structures_and_alogrithms.sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16

 */

public class NumberOfNiceSubArrays {

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfNiceSubarrays(new int[]{1,1,1,1,1},1));
    }
    public static int numberOfNiceSubarrays(int[] nums, int k) {

        int start = 0, count = 0, lastIindex = -1;
        int[] oddArr =  new int[2];

        for(int i = 0; i < nums.length; i++) {

            oddArr[nums[i] % 2] += 1;

            if (oddArr[1] == k ) {
                lastIindex = i;
                while(i+1 < nums.length && nums[i+1] % 2 != 1) {
                    i++;
                }
                while (start <= i && oddArr[1] == k) {
                    count = count + (i-lastIindex) + 1;
                    oddArr[nums[start] % 2] -= 1;
                    start ++;

                }
            }
        }

        return count;

    }
}
