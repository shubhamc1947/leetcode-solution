class Solution {
    public int findLucky(int[] arr) {
        int n=arr.length;
        int ans=-1;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            }else{
                hm.put(arr[i],1);
            }
        }

        Set<Integer>hs=hm.keySet();
        for(Integer curr:hs){
            if(hm.get(curr)==curr){
                ans=Math.max(ans,curr);
            }
        }
        // System.out.println(hm);
        return ans;
    }
}