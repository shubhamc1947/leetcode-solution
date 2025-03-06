class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int solution[]=new int[arr.length];
        Stack<Integer>st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            //- pop
            while(st.size()>0 && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            //work
            if(st.size()==0){
                solution[i]=i;
            }else{
                solution[i]=st.peek();
            }
            //push
            st.push(i);
        }
        for (int i = 0; i < solution.length; i++) {
            solution[i]-=i;
        }
        return solution;
    }
}