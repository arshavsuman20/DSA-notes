/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Map<Node,Node> m=new HashMap<>();
        Node oldtemp=head;
        while(oldtemp!=null){
            Node copynode=new Node(oldtemp.val);
            m.put(oldtemp, copynode);
            oldtemp=oldtemp.next;
        }
        oldtemp=head;
        while(oldtemp!=null){
            Node copy=m.get(oldtemp);
            copy.next=m.get(oldtemp.next);
            copy.random=m.get(oldtemp.random);
            oldtemp=oldtemp.next;
        }
        return m.get(head);
    }
}
