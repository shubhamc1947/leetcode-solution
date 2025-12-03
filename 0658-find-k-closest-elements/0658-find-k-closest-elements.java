class Node{
    int data;
    int diff;
    public Node(int data, int diff){
        this.data=data;
        this.diff=diff;
    }
}
class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //max heap
        PriorityQueue<Node> pq=new PriorityQueue<Node>(
            (a, b) -> {
                if (a.diff != b.diff)
                    return b.diff - a.diff;   // larger diff = higher priority (max-heap)
                return b.data - a.data;        // larger element = higher priority
            }

        );

        int n=arr.length;
        for(int i=0;i<n;i++){
            pq.offer(new Node(arr[i],Math.abs(arr[i]-x)));
            if(pq.size()>k) pq.poll();
        }
        
        List<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().data);
        }
    Collections.sort(ans);        
    return ans;
    }
}