class Solution {
    public int[] nextGreaterEle(int arr[],int n){
        Stack<Integer> st=new Stack<>();
        int nge[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            nge[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nge;
    }
    public int[] prevGreaterEle(int arr[],int n){
        Stack<Integer> st=new Stack<>();
        int nge[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) st.pop();
            nge[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return nge;
    }
    public void printArr(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int nge[]=nextGreaterEle(arr,n);
        // printArr(nge,n);
        int pge[]=prevGreaterEle(arr,n);
        // printArr(pge,n);
        int ans=0;
        for(int i=0;i<n;i++){

            int currArea=Math.abs(nge[i]-pge[i])*arr[i];
            // System.out.println(currArea);
            ans=Math.max(ans,Math.abs(nge[i]-pge[i]-1)*arr[i]);
        }
        return ans;
    }
}