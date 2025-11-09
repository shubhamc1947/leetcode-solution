class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int n=tokens.length;
        for(int i=0;i<n;i++){
            String curr=tokens[i];
            if(curr.equals("+")||curr.equals("-") || curr.equals("*") || curr.equals("/")){
                int b=st.pop();
                int a=st.pop();
                if(curr.equals("+")){
                    st.push(a+b);
                }else if(curr.equals("-")){
                    st.push(a-b);
                }else if(curr.equals("*")){
                    st.push(a*b);
                }else {
                    st.push(a/b);
                }
            }else{
                st.push(Integer.parseInt(curr));
            }
        }
        return st.pop();
    }
}