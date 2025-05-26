package leetcode.easy;

// https://leetcode.com/problems/palindrome-number/description/

import java.util.ArrayList;
import java.util.Stack;

class Task9Solution {
    // idea 1, use stack
    // problem: how do we know when we passed the mid point?
    // Stack<Integer> stack

    // idea 2, simple array list
    // solves the idea 1 problem by just simply querying i and length-i until midpoint of array
    // two passes, one to populate array one to evaluate


    public boolean isPalindrome(int x) {
        ArrayList<Integer> array = new ArrayList<>();

        if (x < 0){
            return false;
        }
        if (x == 0){
            return true;
        }

        while (x != 0){
            int digit = x % 10;

            array.add(digit);

            x /= 10;

        }

        int length = array.size();
        for (int i = 0; i < length / 2; i++){
            if (array.get(i) != array.get(length - i - 1)){
                return false;
            }
        }
        return true;
    }
}

public class Task9_PalindromeNumber {
    public static void main(String[] args){
        Task9Solution solution = new Task9Solution();

        System.out.println(solution.isPalindrome(121));
    }
}
