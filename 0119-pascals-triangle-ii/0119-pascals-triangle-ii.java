class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i - 1; j >= 1; j--){
                int tmp = arr.get(j - 1) + arr.get(j);
                arr.set(j, tmp);
            }
            arr.add(1);
        }
        return arr;
    }
}