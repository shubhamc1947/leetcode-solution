class Solution {
    public int xorOperation(int n, int start) {
        // n and start
        // nums[i]=start+ 2*i (n=> nums.length);
        int ans=0;
        for(int i=0;i<n;i++){
            int curr=start+2*i;
            ans ^=curr;
        }
        return ans;
    }
}