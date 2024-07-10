package com.vaibhavmm.data_structures_and_alogrithms.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;


//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//        Each row must contain the digits 1-9 without repetition.
//        Each column must contain the digits 1-9 without repetition.
//        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

public class ValidSudoku {
    public static void main(String[] args) {



    }

    public static boolean isValidSudoku(char[][] board) {

        for(int i= 0; i< board[0].length ; i++) {

            Set<Character> charSet = initialiseSet();
            Set<Character> charSet2 = initialiseSet();

            for (int j =0; j < board[0].length; j ++) {

                if (!containsDuplicate(charSet, board[i][j])) return false;
                if (!containsDuplicate(charSet2, board[j][i])) return false;

            }

        }

        for(int i= 0; i < board[0].length ; i= i + 3) {

            for (int j =0; j < board[0].length; j = j + 3) {

                Set<Character> charSet = initialiseSet();

                if (!containsDuplicate(charSet, board[i][j])) return false;
                if (!containsDuplicate(charSet, board[i][j + 1])) return false;
                if (!containsDuplicate(charSet, board[i][j + 2])) return false;

                if (!containsDuplicate(charSet, board[i+ 1][j])) return false;
                if (!containsDuplicate(charSet, board[i+1][j + 1])) return false;
                if (!containsDuplicate(charSet, board[i+1][j + 2])) return false;

                if (!containsDuplicate(charSet, board[i+2][j])) return false;
                if (!containsDuplicate(charSet, board[i+2][j + 1])) return false;
                if (!containsDuplicate(charSet, board[i+2][j + 2])) return false;



            }

        }

        return true;

    }

    public static boolean containsDuplicate( Set<Character> charSet, Character boardChar ) {

        if (charSet.contains(boardChar)) {
            if (boardChar != '.') {
                charSet.remove(boardChar);
            }
        } else {
            return false;
        }

        return true;

    }

    public static  Set<Character> initialiseSet() {
        Set<Character> charSet = new HashSet<>();
        charSet.add('1');
        charSet.add('2');
        charSet.add('3');
        charSet.add('4');
        charSet.add('5');
        charSet.add('6');
        charSet.add('7');
        charSet.add('8');
        charSet.add('9');
        charSet.add('.');
        return charSet;
    }

    
}
