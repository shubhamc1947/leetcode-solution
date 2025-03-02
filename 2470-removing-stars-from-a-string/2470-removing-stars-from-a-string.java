class Solution {
    public String removeStars(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }
        System.out.println(st);
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            char curr=st.peek();
            sb.append(curr);
            st.pop();
        }
        return sb.reverse().toString();
    }
}