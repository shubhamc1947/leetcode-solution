class Solution {
    public int[] nse(int arr[],int n){
        Stack<Integer> st=new Stack<>();
        int nextSE[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nextSE[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nextSE;
    }
    public int[] pse(int arr[],int n){
        Stack<Integer> st=new Stack<>();
        int prevSE[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            prevSE[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return prevSE;
    }

    public void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public int sumSubarrayMins(int[] arr) {
        long MOD=1000000007;
        int n=arr.length;
        int nextSE[]=nse(arr,n);
        int prevSE[]=pse(arr,n);
        printArr(nextSE);
        printArr(prevSE);
        long sum=0;
        for(int i=0;i<n;i++){
            long leftContri=i-prevSE[i];
            long rightContri=nextSE[i]-i;

            sum=(sum%MOD+(leftContri*rightContri*arr[i])%MOD)%MOD;
        }
        return (int)sum;
    }
}