class Solution {
    public boolean check(int arr[],int speed,int h){
        int currTime=0;
        for(int i=0;i<arr.length;i++){
            currTime+= Math.ceil(1.0 * arr[i]/speed);
            // System.out.println(Math.ceil(arr[i]/speed));
        }
        // System.out.println(currTime);
        if(currTime>h) return false;
        return true;
    }
    public int minEatingSpeed(int[] arr, int h) {
        int si=0,ei=1000000000;
        int ans=0;

        while(si<=ei){
            int mid=si+((ei-si)/2);
            System.out.println(mid);
            if(check(arr,mid,h)){
                ans=mid;
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return ans;
    }
}