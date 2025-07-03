class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb=new StringBuilder();
        sb.append("a");
        for(int i=0;i<k;i++){
            int len=sb.length();
            if(len>=k+2){
                break;
            }
            System.out.println(len);
            for(int j=0;j<len;j++){
               
                if(sb.charAt(j)=='z'){
                    sb.append('a');
                }else{
                    sb.append((char)((int)sb.charAt(j)+1));
                }
                
            }
            System.out.println(sb);
        }
        return sb.charAt(k-1);
    }
}

// ab
// abc
// abcd
// abcde
// abcdef

// 1
// ab
// 2
// abbc
// 4
// abbcbccd
// 8
// abbcbccdbccdcdde
// 16
// abbcbccdbccdcddebccdcddecddedeef

// 1
// ab
// 2
// abbc
// 4
// abbcbccd