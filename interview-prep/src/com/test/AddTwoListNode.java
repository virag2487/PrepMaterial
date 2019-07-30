package com.test;

import java.math.BigInteger;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order 
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list. You may assume the 
 * two numbers do not contain any leading zero, except the number 0 itself. 
 * Example: 
 *      Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      Output: 7 -> 0 -> 8 
 *      Explanation: 342 + 465 = 807.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * @author virag.shah
 */
public class AddTwoListNode {

    class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) { 
            val = x; 
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null) {
            return null;
        }

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        while(l1 != null || l2 != null) {

            if(l1 != null) {
                num1.append(l1.val);
                l1 = l1.next;
            }

            if(l2 != null) {
                num2.append(l2.val);
                l2 = l2.next;
            }
        }

        BigInteger n1 = new BigInteger(num1.reverse().toString());
        BigInteger n2 = new BigInteger(num2.reverse().toString());

        String result = n1.add(n2).toString();

        ListNode output = new ListNode(Character.getNumericValue(result.charAt(0)));
        ListNode temp = null;
        for(int i = 1; i < result.length(); i++) {
            temp = new ListNode(Character.getNumericValue(result.charAt(i)));
            temp.next = output;
            output = temp;
        }

        return output;
    }
}
