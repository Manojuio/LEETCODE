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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = head.next;
        ListNode res = new ListNode(0); 
        ListNode currRes = res;          

        while (dummy != null) {
            int a = 0;
           
            while (dummy != null && dummy.val != 0) {
                a += dummy.val;
                dummy = dummy.next;
            }

           
            ListNode w = new ListNode(a);
            currRes.next = w;
            currRes = w;

         
            if (dummy != null) {
                dummy = dummy.next;
            }
        }

        return res.next;
    }
}