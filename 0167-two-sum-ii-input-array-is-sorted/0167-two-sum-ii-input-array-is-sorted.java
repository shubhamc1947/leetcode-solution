class Solution {
    public int[] twoSum(int[] arr, int tar) {
                int si = 0, ei = arr.length - 1;
        while (si <= ei) {
            if ((arr[si] + arr[ei]) == tar) {
                return new int[] { si+1, ei+1 };
            } else if (arr[si] + arr[ei] < tar) {
                si++;
            } else {
                ei--;
            }
        }
        return new int[] { -1 };
    }
}