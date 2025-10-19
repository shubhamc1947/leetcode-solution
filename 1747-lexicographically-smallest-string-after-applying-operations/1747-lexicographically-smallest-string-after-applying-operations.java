class Solution {
    public String findLexSmallestString(String ss, int a, int b) {
        
        StringBuilder temp = new StringBuilder(ss);
        StringBuilder ans = temp;
        int n = ss.length();
        
        do{
            
            StringBuilder s = new StringBuilder(temp);
			
            int x = (int)(s.charAt(1)-'0');
            int whichMultiple = 0;
            int zz = x;
			
            for(int i=0;i<10;i++){
                int z = ((i*a)+x)%10;
                if(z<zz){
                    zz = z;
                    whichMultiple = i;
                }
            }
            
            for(int i=0;i<n;i++){
                if(i%2==1){
                    s.setCharAt(i,(char)((((whichMultiple*a)+(s.charAt(i)-'0'))%10)+'0'));
                }
            }
            
            if(b%2==1){
                int y = s.charAt(0)-'0';
                int whichMultiple2 = 0;
                int ww = y;
                for(int i=0;i<10;i++){
                    int z = ((i*a)+y)%10;
                    if(z<ww){
                        ww = z;
                        whichMultiple2 = i;
                    }
                }
                for(int i=0;i<n;i++){
                    if(i%2==0){
                        s.setCharAt(i,(char)((((whichMultiple2*a)+(s.charAt(i)-'0'))%10)+'0'));
                    }
                } 
            }
            
            if(ans.compareTo(s)>0){
                ans = s;
            }
            
            temp.insert(0,temp.substring(n-b,n));
            temp.delete(n,n+b);
        }while(!temp.toString().equals(ss));
        
        return ans.toString();
    }
}