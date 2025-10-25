class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        HashSet<Integer> uniqueNum=new HashSet<>();
        for(int i=left;i<=right;i++){
            uniqueNum.add(i);
        }
        for(int i=0;i<ranges.length;i++){
            for(int j=ranges[i][0];j<=ranges[i][1];j++){
                if(uniqueNum.contains(j)){
                    uniqueNum.remove(j);
                    if(uniqueNum.isEmpty()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}