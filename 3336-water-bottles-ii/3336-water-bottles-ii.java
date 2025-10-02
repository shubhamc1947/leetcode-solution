class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int eb = numBottles, x = numExchange, ans = numBottles;
        while (eb >= x) {
            eb -= x;eb++;
            ans++;x++;
        }
        return ans;
    }
}