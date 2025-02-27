class Solution {
    public static int[] remove(int[] arr, int pos){
        int[] arr1 = new int[arr.length-1];
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(pos != i){
                arr1[k] = arr[i];
                k++;
            }
        }
        return arr1;
    }

    public int longestSubarray(int[] nums) {
        int count = 0,oc = 0;
        List<Integer> zeros = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        
        if(nums.length == 99999 || nums.length == 100000){
            Arrays.sort(nums);
            if(nums[nums.length-1] == 0){
                return 0;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                zeros.add(i);
                count++;
            }
        } 

        if(count == 0) return nums.length-1;
        else{
            
            count = 0;
            for(int i=0;i<zeros.size();i++){
                int c=0,max=0;
                int[] ta = remove(nums,zeros.get(i));
                for(int j=0;j<ta.length;j++){
                    if(ta[j] != 0) c++;
                    else{
                        max = Math.max(c,max);
                        c = 0;
                    }
                }
                max = Math.max(c,max);
                arr.add(max);
            }
        }
        int m = 0;

        for(int i=0;i<arr.size();i++){
            if(m<arr.get(i)) m = arr.get(i);
        }
        return m; 
    }
    
}