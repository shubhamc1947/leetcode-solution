class Node{
    int key;
    int val;
    Node next;
    public  Node(int key,int val){
        this.key=key;
        this.val=val;
        this.next=null;
    }
}
class MyHashMap {
    Node arr[];
    public MyHashMap() {
        this.arr=new Node[10000];
    }
    
    public void put(int key, int value) {
        int idx=key%10000;
        if(arr[idx]==null){
            arr[idx]=new Node(-1,-1); //(creating a dummy node);
            arr[idx].next=new Node(key,value);
        }else{
            Node prev=arr[idx];//
            Node temp=arr[idx].next;
            while(temp!=null){
                // checking if the key is already there?
                if(temp.key==key){
                    temp.val=value;
                    return;
                }
                prev=prev.next;
                temp=temp.next;
            }
            prev.next=new Node(key,value);

        }
    }
    
    public int get(int key) {
        int idx=key%10000;
        if(arr[idx]==null){
            return -1;
        }else{
            Node temp=arr[idx].next;
            while(temp!=null){
                if(temp.key==key){
                    return temp.val;
                }
                temp=temp.next;
            }
            return -1;
        }
    }
    
    public void remove(int key) {
        int idx=key%10000;
        if(arr[idx]==null){
            return;
        }else{
            Node temp=arr[idx].next;
            Node prev=arr[idx];
            while(temp!=null){
                if(temp.key==key){
                    prev.next=temp.next;
                    return;
                }
                temp=temp.next;
                prev=prev.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */