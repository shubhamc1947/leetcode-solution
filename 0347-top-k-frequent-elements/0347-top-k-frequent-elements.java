class Node{
    int data;
    int freq;
    public Node(int data,int freq){
        this.data=data;
        this.freq=freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        //step 1 , find the frequency
        int n=arr.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }

        //step 2 , 
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.freq-b.freq);

        for (int nums:hm.keySet()){
            pq.offer(new Node(nums,hm.get(nums)));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[]=new int[pq.size()];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++]=pq.poll().data;
        }
        return ans;

    }
}