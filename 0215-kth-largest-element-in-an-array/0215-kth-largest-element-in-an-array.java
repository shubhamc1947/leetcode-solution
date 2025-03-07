class Solution {
    public int findKthLargest(int[] arr, int k) {
        //better way
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<arr.length;i++)       {
            if(pq.size()<k){
                pq.add(arr[i]);
            }else{
                if(pq.peek()<arr[i]){
                    pq.add(arr[i]);
                    pq.remove();
                }
            }
            
        }
        return pq.peek();
    }
}