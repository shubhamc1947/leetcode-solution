class Node{
    int val;
    int diff;
    public Node(int val,int diff){
        this.val=val;
        this.diff=diff;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Node> pq=new PriorityQueue<>(
            (a,b)-> {
                if(a.diff!=b.diff){
                return b.diff-a.diff;
            }else{
                return b.val-a.val;
            }
            }
        )  ;
        int n=arr.length;
        for(int i=0;i<n;i++) {
            pq.add(new Node(arr[i],Math.abs(x-arr[i])));
            if(pq.size()>k){
                pq.remove();
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.remove().val);
        }
        Collections.sort(ans);
        return ans;
        
    }
}