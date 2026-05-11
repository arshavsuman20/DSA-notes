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
    public ListNode mergeKLists(ListNode[] lists) {
        //current smallest nodes in min heap
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists){
            if(node!=null) pq.add(node); //head in heap
        }
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(!pq.isEmpty()){
            ListNode small=pq.poll(); //smallest node pop
            tail.next=small;//result add in list
            tail=tail.next;
            if(small.next!=null){ //if next node exists, add in heap
                pq.add(small.next);
            }
        }
        return dummy.next;
    }
}
