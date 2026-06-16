class Solution {
    public String processStr(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<n;i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                sb.append(s.charAt(i));
            }else if(s.charAt(i)=='*'){
                if(sb.length()>=1){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else if(s.charAt(i)=='#'){
                String curr=sb.toString();
                for(int x=0;x<curr.length();x++){
                    sb.append(curr.charAt(x));
                }
            }else if(s.charAt(i)=='%'){
                sb.reverse();
            }
        }
        return sb.toString();
    }
}