class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length ;

        if(n < 3) return 0 ;

        Arrays.sort(nums) ;

        int res = 0 ;

        for(int i = 0 ; i < n ;  i ++) 
        {
            for(int j = i + 1 ; j < n ;  j ++) 
            {
                int sum = nums[i] + nums[j] ;

                int low = j + 1 ;
                int high = n - 1 ;

                int ans = -1 ;

                while(low <= high) 
                {
                    int mid = low + (high - low) / 2 ;

                    if(nums[mid] < sum) 
                    {
                        ans = mid ;
                        low = mid + 1 ;
                    }
                    else 
                    {
                        high = mid - 1 ;
                    }
                }

                if(ans > j) 
                {
                    res += ans - j ;
                }
            }
        }

        return res ;
    }
}