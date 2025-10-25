class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int prefixArr[]=new int[52];
        for(int i=0;i<ranges.length;i++){
            prefixArr[ranges[i][0]]++;
            prefixArr[ranges[i][1]+1]--;
        }

        for(int i=1;i<51;i++){
            prefixArr[i]+=prefixArr[i-1];
        }

        for(int i=left;i<=right;i++){
            if(prefixArr[i]==0) return false;
        }
        return true;
    }
}