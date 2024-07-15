//package com.vaibhavmm.data_structures_and_alogrithms.sliding_window;
//
//// https://leetcode.com/problems/trapping-rain-water/description/
//public class TrappingRainWater {
//    public static void main(String[] args) {
//        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//    }
//
//    public static  int trap(int[] height) {
//
//        int g = height[0], areaSum = 0;
//        int area = 0, start = 0,last = 0;
//
//        for (int i = 0; i < height.length; i ++) {
//
//
//
//            if (g > 0 && g < height[i]) {
//                last = i;
//
//                while (start < last) {
//                    areaSum += Math.abs((height[last] - height[start])) ;
//                    start ++;
//                }
//            }
//            g = Math.max(g,  height[i]);
//
//            if (g == 0) {
//                start ++;
//            }
//
//
//
//
//
//
//        }
//
//        return areaSum;
//    }
//}
