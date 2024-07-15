package com.vaibhavmm.data_structures_and_alogrithms.arrays_and_hashing;

import java.util.ArrayList;
import java.util.Collections;

/* https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

Input: n = 6, arr[] = {16,17,4,3,5,2}
Output: 17 5 2


 */

public class ArrayLeaders {

    public static void main(String[] args) {
        System.out.println(leaders_bruteforce(6,new int[]{16,17,4,3,5,2}));
        System.out.println(leaders_vm(6,new int[]{16,17,4,3,5,2}));
    }

    public static ArrayList<Integer> leaders_bruteforce(int n, int arr[]) {

        ArrayList<Integer> res = new ArrayList<>();


        for(int i = 0; i < n; i ++) {

            int j = 0;
            for ( j = i + 1; j < n ; j ++) {

                if (arr[i] < arr[j]) {
                    break;
                }

            }

            if (j == n) {
                res.add(arr[i]);
            }

        }

        return res;
    }

    public static ArrayList<Integer> leaders_vm(int n, int arr[]) {

        ArrayList<Integer> res = new ArrayList<>();

        res.add(arr[n-1]);
        int g = arr[n-1];

        for (int i = n-2; i >= 0; i --) {
            if (g <= arr[i]) {
                res.add(arr[i]);
                 g = arr[i];
            }
        }

        Collections.reverse(res);

        return res;
    }

}
