class Solution {

    public boolean isPalindrome(String s) {
        int si=0,ei=s.length()-1;
        s= s.toLowerCase();
        while(si<=ei){

            if(!Character.isLetterOrDigit(s.charAt(si))){
                si++;
            }else if(!Character.isLetterOrDigit(s.charAt(ei))){
                ei--;
            }else if(s.charAt(si)==s.charAt(ei)){
                si++;
                ei--;
            }else{
                return false;
            }
        }
        return true;
    }
}