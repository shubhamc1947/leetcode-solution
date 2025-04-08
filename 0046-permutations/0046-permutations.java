class Solution {
    private static void permutation(int arr[], int idx, List<List<Integer>> ans) {
        if (idx == arr.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                temp.add(arr[i]);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            // swap i and idx
            swap(i, idx, arr);
            permutation(arr, idx + 1, ans);
            swap(i, idx, arr);

        }
    }

    private static void swap(int a, int b, int arr[]) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        // arr[a] = arr[a] ^ arr[b];
        // arr[b] = arr[a] ^ arr[b];
        // arr[a] = arr[a] ^ arr[b];
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutation(nums, 0, ans);
        return ans;

    }
}