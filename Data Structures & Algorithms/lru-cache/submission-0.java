class LRUCache {
    //DLL
    class Node{
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    Node head=new Node(-1, -1);
    Node tail=new Node(-1, -1);
    int capacity;
    HashMap<Integer, Node> m=new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    //add node right after head
    void addNode(Node newNode){
        Node temp=head.next;
        newNode.next=temp;
        newNode.prev=head;
        head.next=newNode;
        temp.prev=newNode;
    }
    //remove node from dll
    void deleteNode(Node dNode){
        Node dprev=dNode.prev;
        Node dnext=dNode.next;
        dprev.next=dnext;
        dnext.prev=dprev;
    }
    public int get(int key) {
        if(m.containsKey(key)){
            Node resNode=m.get(key);
            int res=resNode.val;
            m.remove(key); //remove old mapping
            deleteNode(resNode); //move accessed node to front
            addNode(resNode);
            m.put(key,head.next); //update
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //if key already exists
        if(m.containsKey(key)){
            Node x=m.get(key);
            m.remove(key);
            deleteNode(x);
        }
        //if capacity reached
        if(m.size()==capacity){
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key,value)); //add node at front
        m.put(key,head.next);
    }
}
