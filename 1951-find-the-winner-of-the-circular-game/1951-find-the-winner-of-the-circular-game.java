class Solution {
    public int findTheWinner(int n, int k) {
        if(n==1){
            return 1;
        }
        Queue<Integer> que=new LinkedList<>();
        for(int i=1;i<=n;i++){
            que.add(i);
        }

        while(true){
            for(int i=1;i<=k;i++){
                int curr=que.remove();
                if(i!=k){
                    que.add(curr);
                }
            }
            if(que.size()==1){
                break;
            }
        }
        return que.remove();
    }
}