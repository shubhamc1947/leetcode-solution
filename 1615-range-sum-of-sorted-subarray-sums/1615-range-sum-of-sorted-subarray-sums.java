class Solution {
    public int rangeSum(int[] arr, int n, int left, int right) {
        ArrayList<Integer> subArrSum=new ArrayList<>();
        for(int i=0;i<n;i++){
            int currSum=0;
            for(int j=i;j<n;j++){
                currSum+=arr[j];
                subArrSum.add(currSum);
            }
        }

        Collections.sort(subArrSum);
        System.out.println(subArrSum);
        int ans=0;
        int MOD=1000000007;
        for(int i=left-1;i<right;i++){
            ans=(ans+subArrSum.get(i))%MOD;
        }
        return ans;
    }
}