class Solution {
    public int maxArea(int[] arr) {
        int l=0,r=arr.length-1;
        int area=0;
        while(l<r){
            int h=Math.min(arr[l],arr[r]);
            int w=r-l;
            area=Math.max(area,h*w);
            if(arr[l]<arr[r]){
                l++;
            }else{
                r--;
            }
        }
        return area;
    }
}