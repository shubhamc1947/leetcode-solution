class Solution {
    public int countPrimes(int n) {
        if(n<=1) return 0;
        int arr[]=new int[n];
        //0-> prime, 1-> noPrime
        arr[0]=1;
        arr[1]=1;
        int count=0;
        for(int i=2;i<n;i++){
            if(arr[i]==0){
                count++;
                for(long j=(long)i*i;j<n;j=j+i){
                    arr[(int)j]=1;
                }
            }
        }
        return count;
    }
}