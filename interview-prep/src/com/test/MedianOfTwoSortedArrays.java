package com.test;

/** 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)). You may assume nums1 and nums2 cannot be both empty. 
 * Example 1: 
 *      nums1 = [1, 3] 
 *      nums2 = [2] 
 *      The median is 2.0 
 * Example 2: 
 *      nums1 = [1, 2] 
 *      nums2 = [3, 4] 
 *      The median is (2 + 3)/2 = 2.5
 *
 * @author virag.shah
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // boundary check
        if(nums1 == null && nums2 == null) {
            return 0.0;
        }

        int m = 0, n = 0, k = 0;
        int[] result = new int[nums1.length + nums2.length];

        // iterate the arrays and merge into 1 sorted array
        while(m < nums1.length && n < nums2.length) {

            if(nums1[m] < nums2[n]) {
                result[k++] = nums1[m++];
            }
            else {
                result[k++] = nums2[n++];
            } 
        }

        // add remaining nums1
        while(m < nums1.length) {
            result[k++] = nums1[m++];
        }

        // add remaining nums2
        while(n < nums2.length) {
            result[k++] = nums2[n++];
        }

        // get middle element
        int mid = result.length / 2;

        // if odd number of elements in result
        if(result.length % 2 == 1) {
            return result[mid];
        }
        // if even number of elements in result
        else {
            return (double) (result[mid] + result[mid - 1]) / 2;
        }
    }
}
