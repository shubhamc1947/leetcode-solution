class Solution {
    public int fact(int n){
        if(n==0 || n==1) return 1;
        return n* fact(n-1);
    }
    
    public String getPermutation(int n, int k) {
        String res="";
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(i);
        }
        int factn=fact(n-1);
        k=k-1;
        while(true){
            int idx=k/factn;
            res=res+""+arr.get(idx);
            arr.remove(idx);
            if(arr.size()==0){
                break;
            }
            k=k%factn;
            factn=factn/arr.size();
        }
        return res;
    }
}