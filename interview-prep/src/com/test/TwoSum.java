package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target. 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice. 
 * Example: 
 *      Given nums = [2, 7, 11, 15], target = 9, 
 *      Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * @author virag.shah
 */
class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        if(nums == null || nums.length < 2) {
            return null;
        }

        List<Integer> numList = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {

            if(numList.contains(target - nums[i])) {
                return new int[] {numList.indexOf(target - nums[i]), i};
            }
            else {
                numList.add(nums[i]);
            }
        }

        return null;
    }
}
