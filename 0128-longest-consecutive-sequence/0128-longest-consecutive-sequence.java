class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> temp = new HashSet<>();
        for(int num : nums){
            temp.add(num);
        }
        int ans = 0;
        for(int num: temp){
            if(!temp.contains(num - 1)){
                int currNum = num;
                int currLen = 1;
            
            while(temp.contains(currNum+1)){
                currNum++;
                currLen++;
            }
            ans = Math.max(ans,currLen);
        }
        }
        return ans;
    }
}