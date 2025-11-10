class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {

        int n=arr.length;
        int ans[]=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<Integer>();

        for(int i=0;i<n;i++){
            //remove all excess indexs
            if(!dq.isEmpty() && i-dq.getFirst()==k){
                dq.removeFirst();
            }
            // remove all smaller
            while(!dq.isEmpty() && arr[dq.getLast()]<arr[i]){
                dq.removeLast();
            }

            // add in dq
            dq.addLast(i);
            if(i+1>=k){
                ans[i+1-k]=arr[dq.getFirst()];
            }
        }
        return ans;
    }
}