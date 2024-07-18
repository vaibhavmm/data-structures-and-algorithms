package com.vaibhavmm.data_structures_and_alogrithms.sliding_window;

import java.util.*;

public class MaxSlidingWindow {


    public static void main(String[] args) {
        System.out.println(solFromLeetCode(new int[]{1,3,-1,-3,5,3,6,7}, 3));


    }


    // Solution taken from Leetcode to understand
    public static int[] solFromLeetCode(int[] nums, int k) {
        int n = nums.length;
        int max[] = new int[n-k+1];
        int r = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            // remove numbers out of boundary (out of range k)
            if(!q.isEmpty() && q.peek() == i-k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless;
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            q.offer(i);
            if(i >= k-1) {
                max[r++] = nums[q.peek()];
            }

        }

        return max;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int start = 0;
        int[] res = new int[nums.length - k + 1];

        PriorityQueue<Integer> windowQ
                = new PriorityQueue<>(
                (a, b) -> {
                    if (a < b)
                        return 1;
                    if (a > b)
                        return -1;
                    return 0;
                });


        for (int i = 0; i < nums.length; i ++) {

            windowQ.add(nums[i]);
            if (windowQ.size() == k) {
                res[start] = windowQ.poll();
                windowQ.add(res[start]);
                windowQ.remove(nums[start]);
                start ++;
            }

        }

        return res;

    }
}
