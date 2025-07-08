class Solution {
    public void lowerBoundReplace (ArrayList<Integer> temp,int si,int ei,int tar){
        int idx=-1;
        while(si<=ei){
            int mid=(si+ei)/2;
            if(temp.get(mid)>=tar){
                idx=mid;
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        temp.set(idx,tar);
        // System.out.println(temp);
    }
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arr[0]);
        int len=1;
        for(int i=1;i<n;i++){
            if(arr[i]>temp.get(len-1)){
                temp.add(arr[i]);
                len++;
            }else{
                lowerBoundReplace(temp,0,len-1,arr[i]);
            }
        }
        return len;
        
    }
}