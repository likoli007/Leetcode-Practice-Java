package cz.muni.fi.pa165.triolingo.easy;

import java.util.Arrays;
import java.util.HashMap;

/*
    https://leetcode.com/problems/two-sum/description/
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] + nums[i] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    // faster, but more space used
    public int[] twoSumHash(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            int num1 = nums[i];
            int desired = target - num1;

            if (map.get(desired) != null && map.get(desired) != i){
                return new int[]{i, map.get(desired)};
            }
        }
        return new int[2];
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSumHash(new int[]{2, 7, 11, 15}, 9)));
    }
}
