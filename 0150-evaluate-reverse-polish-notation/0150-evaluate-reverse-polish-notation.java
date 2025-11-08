class Solution {
    public int evalRPN(String[] arr) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("+") || arr[i].equals("-")||arr[i].equals("*")||arr[i].equals("/")){
                int a=st.pop();
                int b=st.pop();
                if(arr[i].equals("+")){
                    st.push(b+a);
                }else if(arr[i].equals("-")){
                    st.push(b-a);
                }else if(arr[i].equals("*")){
                    st.push(b*a);
                }else if(arr[i].equals("/")){
                    st.push(b/a);
                }
            }else{
                st.push(Integer.parseInt(arr[i]));
            }
        }
        return st.pop();
    }
}