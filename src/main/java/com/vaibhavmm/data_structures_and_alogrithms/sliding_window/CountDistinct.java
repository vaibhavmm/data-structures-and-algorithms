package main.java.com.vaibhavmm.data_structures_and_alogrithms.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/0
public class CountDistinct {


    // 7 4
    // 1 2 1 3 4 2 3
    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{1 ,2 ,1 ,3 ,4 , 2 , 3},7,4));
    }


    static ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        int start = 0;
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> mapW = new HashMap<>();
        for(int i = 0; i< A.length; i ++) {
            mapW.put(A[i], mapW.getOrDefault(A[i],0) + 1);
            if (i- start + 1 == k) {
                res.add(mapW.size());
                int val;
                mapW.put(A[start], val = mapW.get(A[start]) - 1);
                if (val == 0) mapW.remove(A[start]);
                start ++;
            }
        }
        return res;
    }
}
