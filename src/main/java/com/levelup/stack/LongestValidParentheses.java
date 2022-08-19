package com.levelup.stack;

/**
 * Problem statement: https://leetcode.com/problems/longest-valid-parentheses/
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * Example
     * Input: s = "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
     * Input: s = ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()".
 *
 *
 *  PseudoCode:
 *
 *  Constraint
     *  0 <= s.length <= 3 * 104
     * s[i] must be either '(' or ')'
 */
public class LongestValidParentheses {
    private String s;

    public void LongestValidParentheses(String parentheses) {
        this.s = parentheses;
    }


    public int getLongestValidParentheses() {

        // Variable to store the longest valid parentheses
        int count = 0;
        // Left counter will count the number of '('
        int left = 0;
        // Right counter will count the number of ')'
        int right = 0;
        // Loop through the string from left to right.
        // This will take care of extra right parentheses
        for (int i = 0; i < s.length(); i++) {
            // Current character
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            // If both left and right are equal,
            // it means we have a valid substring
            if (left == right) {
                count = Math.max(count, left + right);
            }
            // If right is greater than left,
            // it means we need to set both
            // counters to zero
            if (right > left) {
                left = right = 0;
            }
        }
        // Reset left and right
        left = right = 0;
        // Follow the same approach but now loop the string
        // from right to left. This will take care of extra
        // left parentheses
        for (int i = s.length() - 1; i >= 0; i--) {
            // Current character
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            // If both left and right are equal,
            // it means we have a valid substring
            if (left == right) {
                count = Math.max(count, left + right);
            }
            // If left is greater than right,
            // it means we need to set both
            // counters to zero
            if (left > right) {
                left = right = 0;
            }
        }
        return count;
    }

}
