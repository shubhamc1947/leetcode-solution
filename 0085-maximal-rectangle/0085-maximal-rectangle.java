class Solution {
    public int largestRec(int [] height){
        Stack<Integer> st=new Stack<>();
        int n=height.length,max=0;
        for(int i=0;i<=n;i++){
            int curr=(i==n?0 : height[i]);
            while(!st.isEmpty() && height[st.peek()]>curr){
                int h=height[st.pop()];
                int w=st.isEmpty()?i:i-st.peek()-1;
                max=Math.max(max,h*w);
            }
            st.push(i);
        }
        return max;
    }
    public int maximalRectangle(char[][] arr) {
        if(arr.length==0) return 0;
        int n=arr.length;
        int m=arr[0].length;
        int height[]=new int[m];
        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                height[j]=arr[i][j]=='1'?height[j]+1:0;
            }
            ans=Math.max(ans,largestRec(height));
        }
        return ans;
    }
}