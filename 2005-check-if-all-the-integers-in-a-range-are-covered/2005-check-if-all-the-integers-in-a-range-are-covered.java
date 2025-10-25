class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] cover = new int[52];

        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                cover[i] = 1;
            }
        }

        for (int i = left; i <= right; i++) {
            if (cover[i] == 0) return false;
        }
        return true;

    }
}