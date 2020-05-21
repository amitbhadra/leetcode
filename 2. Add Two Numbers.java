/*
 * 2. Add Two Numbers Medium
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 * 
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode temp, head=sum;
        int carry=0;
        while(l1!=null&&l2!=null) {
            temp = new ListNode((l1.val+l2.val+carry)%10);
            carry = (l1.val+l2.val+carry)/10;
            sum.next = temp;
            sum = temp;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1==null&&l2!=null) {
            while(l2!=null) {
                temp = new ListNode((l2.val+carry)%10);
                carry = (l2.val+carry)/10;
                sum.next = temp;
                sum = temp;
                l2 = l2.next;
            }
        }
        if(l1!=null&&l2==null) {
            while(l1!=null) {
                temp = new ListNode((l1.val+carry)%10);
                carry = (l1.val+carry)/10;
                sum.next = temp;
                sum = temp;
                l1 = l1.next;
            }
        }
        if(carry==1) {
            temp = new ListNode(1);
            sum.next = temp;
        }
        return head.next;
    }
}