package com.vaibhavmm.data_structures_and_alogrithms.sliding_window;

import java.util.ArrayList;

/*
https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/0

Input: arr[] = [1,2,3,7,5], n = 5, s = 12
Output: 2 4
Explanation: The sum of elements from 2nd to 4th position is 12.
Input: arr[] = [1,2,3,4,5,6,7,8,9,10], n = 10, s = 15,
Output: 1 5
Explanation: The sum of elements from 1st to 5th position is 15.
Input: arr[] = [7,2,1], n = 3, s = 2
Output: 2 2
Explanation: The sum of elements from 2nd to 2nd position is 2.
Input: arr[] = [5,3,4], n = 3, s = 2
Output: -1
Explanation: There is no subarray with sum 2
 */

public class IndicesOfSubArraySum {
    public static void main(String[] args) {

//        System.out.println(subarraySum(new int[]{1,2,3,7,5}, 5,12));
//        System.out.println(subarraySum(new int[]{1,2,3,4,5,6,7,8,9,10}, 10,15));
//        System.out.println(subarraySum(new int[]{7,2,1}, 3,2));
//        System.out.println(subarraySum(new int[]{5,3,4}, 3,2));

        System.out.println(subarraySum(new int[]{1,2,3,4}, 4,0));
//
//
//        System.out.println(subarraySum_op(new int[]{135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28,
//                162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139,
//                70, 113, 68, 100, 36, 95, 104, 12, 123, 134},42,468));
    }



    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        int start = 0,last = 0, sum = 0;
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i ++) {

            sum = sum + arr[i];

            if (sum >= s) {
                last = i;
                while (sum > s && start < last) {
                    sum = sum - arr[start];
                    start++;
                }

                if (sum == s) {
                    res.add(start + 1);
                    res.add(last + 1);
                    return res;
                }
            }

        }

        res.add(-1);
        return res;

    }

}
