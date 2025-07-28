class Solution {
    public int countHillValley(int[] nums) {
        java.util.List<Integer> temp = new java.util.ArrayList<>();
        for (int x : nums) {
            if (!temp.isEmpty() && temp.get(temp.size()-1) == x) continue;
            temp.add(x);
        }
        int cnt = 0;
        for (int i = 1; i < temp.size()-1; i++) {
            int a = temp.get(i-1), b = temp.get(i), c = temp.get(i+1);
            if ((b > a && b > c) || (b < a && b < c)) cnt++;
        }
        return cnt;
    }
}