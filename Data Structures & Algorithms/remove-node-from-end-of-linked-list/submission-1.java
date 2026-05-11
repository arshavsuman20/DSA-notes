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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        //move fast to n steps ahead
        for(int i=0;i<n;i++) fast=fast.next;
        ListNode slow=head;
        if(fast==null)return head.next;
        while(fast.next!=null){//together
            slow=slow.next;
            fast=fast.next;
        }
        //n nodes gap between fast and slow
        //when fast reaches end, slow is exactly at node to be deleted.
        ListNode delNode=slow.next;
        slow.next=slow.next.next;
        return head;
    }
}
