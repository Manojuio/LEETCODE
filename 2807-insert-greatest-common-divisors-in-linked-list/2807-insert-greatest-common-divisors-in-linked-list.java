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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = head;
        while(dummy.next!=null){
             int a  = dummy.val;
             ListNode n = dummy.next;
             int b = n.val;
             int ans = gcd(a,b);
             ListNode w = new ListNode(ans);
             dummy.next = w;
             w.next = n;
             dummy = n;
        }
        return head;
    }
    public int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}