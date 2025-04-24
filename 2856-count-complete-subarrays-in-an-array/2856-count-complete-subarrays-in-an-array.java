class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        HashSet<Integer> hs=new HashSet<>();

        for(int i=0;i<n;i++){
            hs.add(nums[i]);
        }
        int distintCount=hs.size();
        int count=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> fre=new HashSet<>();
            for(int j=i;j<n;j++){
                fre.add(nums[j]);
                if(fre.size()==distintCount) count++;
            }
        }
        return count;
    }
}