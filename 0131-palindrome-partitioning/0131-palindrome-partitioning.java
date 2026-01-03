class Solution {
    public void solve(String s,int idx,int n,List<List<String>> res,List<String> curr){
        if(idx==n){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<n;i++){
            if(isPalindrone(s,idx,i)){
                curr.add(s.substring(idx,i+1));
                solve(s,i+1,n,res,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isPalindrone(String s,int si,int ei){
        while(si<ei){
            if(s.charAt(si)!=s.charAt(ei)) return false;
            si++;
            ei--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        solve(s,0,s.length(),res,new ArrayList<>());
        return res;
    }
}