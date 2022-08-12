package com.levelup.slidingwindow;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * Problem statement : find max of each subarray of size k from given array of size k
 * Example:
 *     Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 *     Output: [3,3,5,5,6,7]
 *
 *     Window position        Max of Window Size K
 *     [1,3,-1],-3,5,3,6,7              3
 *     1,[3,-1,-3],5,3,6,7              3
 *     1,3,[-1,-3,5],3,6,7              5
 *     1,3,-1,[-3,5,3,]6,7              5
 *     1,3,-1,-3,[5,3,6],7              6
 *     1,3,-1,-3,5,[3,6,7]              7
 *
 * Clarification
 *  1: Is window size  be constant or dynamic?
 *      Dynamic
 *  2: Can Array input have all negative element?
 *      Yes
 *
 * Constraint
 * 1: Window  size: should be greater than 1 and lest than length of array of size n
 * 2: Array Length : should be greater than length of k and k<=Input.length <= 10^4
 * 3: Input Array element: 10^-4 <=Input Element in Array<=10^4
 *
 * Solution
 * 1. Brute force O(NxK)
 * 2. Sliding Window
 *      Rolling Hash with the help of index
 *
 * Pseudo code
 *
 */
public class MaxOfEachSubArrayK {
}
