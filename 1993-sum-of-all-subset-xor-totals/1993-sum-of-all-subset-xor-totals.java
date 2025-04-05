class Solution {
    public  int sum;

    public  void perma(int arr[], int i, ArrayList<Integer> ans) {
        if (i == arr.length) {
            int s = 0;
            for (int k = 0; k < ans.size(); k++) {
                s = s ^ ans.get(k);
            }
            sum = sum + s;
            return;
        }
        // not add
        perma(arr, i + 1, ans);
        // add
        ans.add(arr[i]);
        perma(arr, i + 1, ans);
        ans.remove(ans.size() - 1);
    }
    public  int subsetXORSum(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        perma(nums,  0,  ans);
        return sum;
    }
}