/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant 
 *  digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 
 *  
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
    	Stack<Integer> s2 = new Stack<Integer>();

    	while (l1 != null) {
    		s1.push(l1.val);
    		l1 = l1.next;
    	}
    	while (l2 != null) {
    		s2.push(l2.val);
    		l2 = l2.next;
    	}

    	ListNode cur = new ListNode(0);
    	int sum = 0;
    	while (!s1.empty() || !s2.empty()){
    		if (!s1.empty()){
    			sum += s1.pop();
    		}
    		if (!s2.empty()){
    			sum += s2.pop();
    		}

    		cur.val = sum % 10;
    		ListNode next = new ListNode(sum / 10);
    		next.next = cur; 
    		cur = next;
    		sum = sum / 10;
    	}
        
        if (cur.val == 0)
        	return cur.next;
        else 
        	return cur;
    }
}