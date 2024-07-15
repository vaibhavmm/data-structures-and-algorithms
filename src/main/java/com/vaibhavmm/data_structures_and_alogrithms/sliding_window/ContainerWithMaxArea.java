package com.vaibhavmm.data_structures_and_alogrithms.sliding_window;

// https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,3,2,5,25,24,5}));
    }

    public static int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length -1;

        while (left < right) {

            int area =  Math.min(height[left] , height[right]) * (right -left);
            max = Math.max(max, area);

            if (height[left] <= height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return max;

    }

}
