class Solution {
    public int findMin(int[] arr) {
        int si = 0, ei = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (si <= ei) {
            int mid = si - (si - ei) / 2;
            if(mid>0&&arr[mid]<arr[mid-1])return arr[mid];
            if (arr[mid] >= arr[si] && arr[mid] > arr[ei]) {
                si = mid + 1;
            } else {
                // ans = Math.min(ans, arr[mid]);
                ans = arr[mid];
                ei = mid - 1;
            }
        }
        return ans;
    }
}