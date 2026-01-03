class Solution {
    public int fact(int n){
        if(n==0 || n==1) return 1;
        return n*fact(n-1);
    }
    public void helper(ArrayList<Integer> arr,int n,int k,String res[]){
        if(arr.size()==0){
            return;
        }
        int factn=fact(n);
        int idx=k/factn;
        res[0]=res[0]+""+arr.get(idx);
        arr.remove(idx);
        helper(arr,n-1,k%factn,res);

    }
    public String getPermutation(int n, int k) {
        String res[]=new String[1];
        res[0]="";
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(i);
        }

        helper(arr,n-1,k-1,res);
        return res[0];
    }
}