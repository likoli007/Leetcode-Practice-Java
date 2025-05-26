package leetcode.medium;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashSet;
import java.util.Set;

public class Task3_LongestSubstringWithoutRepeatingCharacters {
    static class Solution {
        // idea 1: iteratively build for each letter with set

        // idea 2: try to do it with sliding windows

        // conclusion: sliding windows were definitely faster

        public int lengthOfLongestSubstring(String s) {
            int best = 0;

            for (int i = 0; i < s.length(); i++){
                Set<Character> set = new HashSet<>();
                int current = 0;
                for (int j = 0; i+j < s.length(); j++){
                    Character c = s.charAt(i + j);
                    if (set.contains(c)){
                        if (current > best){
                            best = current;
                        }
                        break;
                    }
                    else{
                        set.add(c);
                        current++;
                    }
                    if (i+j == s.length() - 1 && current > best){
                        best = current;
                    }
                }

            }

            return best;

        }

        public int lengthOfLongestSubstringSliding(String s) {
            int best = 0;

            int left = 0;
            int right = 0;

            Set<Character> set = new HashSet<>();

            while (right < s.length()){
                if (set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
                else {
                    set.add(s.charAt(right));
                    right++;
                }


                best = Math.max(best, (right - left));
            }
            return best;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(" "));

        System.out.println(solution.lengthOfLongestSubstringSliding("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstringSliding("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstringSliding("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstringSliding(" "));

    }
}
