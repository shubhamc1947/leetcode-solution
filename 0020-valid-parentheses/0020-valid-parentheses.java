class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        if(n==0||n==1) return n==0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(curr=='('||curr=='['||curr=='{'){
                st.push(curr);
            }else{
                if(st.isEmpty()) return false;
                if((curr==')' && st.peek()=='(') || (curr=='}' && st.peek()=='{') || (curr==']' && st.peek()=='[')){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}