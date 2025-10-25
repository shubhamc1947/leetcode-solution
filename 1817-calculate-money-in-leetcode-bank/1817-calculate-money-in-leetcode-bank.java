class Solution {
    public int totalMoney(int n) {
        
        int ans=0;
        int mon=-1;
        while(n>0){
            mon++;
            int curr=0;
            for(int j=1;j<=7;j++){
                curr=curr+mon+j;
                n--;
                if(n==0){
                    break;
                }
                System.out.println(curr+" "+mon+" "+j+" "+ans);
            }
            ans+=curr;
        }
        return ans;
    }
}