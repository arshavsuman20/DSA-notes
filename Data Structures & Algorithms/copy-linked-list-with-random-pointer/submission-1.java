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
        m.put(null,null);
        Node oldtemp=head;
        while(oldtemp!=null){
            if(!m.containsKey(oldtemp)){
                m.put(oldtemp, new Node(0));
            }
            m.get(oldtemp).val=oldtemp.val;
            if(!m.containsKey(oldtemp.next)){
                m.put(oldtemp.next, new Node(0));
            }
            m.get(oldtemp).next=m.get(oldtemp.next);
            if(!m.containsKey(oldtemp.random)){
                m.put(oldtemp.random, new Node(0));
            }
            m.get(oldtemp).random=m.get(oldtemp.random);
            oldtemp=oldtemp.next;
        }
        return m.get(head);
    }
}
