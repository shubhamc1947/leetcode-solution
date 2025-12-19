class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
            this.next=null;
            this.prev=null;
        }
    }

    
    int capacity;
    HashMap<Integer, Node> hm;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.hm=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }else{
            
            Node curr=hm.get(key);
            // delete Node void
            deleteNode(curr);
            // insert on head
            insertHead(curr);
            return curr.val;
        }
    }

    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node curr=hm.get(key);
            curr.val=value;
            deleteNode(curr);
            insertHead(curr);
        }else{
            //
            if(hm.size()>=capacity){
                Node rm=tail.prev;
                deleteNode(rm);
                hm.remove(rm.key);
            }
            Node newNode=new Node(key,value);
            hm.put(key,newNode);
            insertHead(newNode);
        }
    }

    public void deleteNode(Node curr){
        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
    }
    public void insertHead(Node curr){
        curr.next=head.next;
        head.next.prev=curr;
        head.next=curr;
        curr.prev=head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */