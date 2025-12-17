class Solution {
    private static final long INF = 1_000_000_000_000L;
    
    enum State {
        HOLD_NORMAL, HOLD_SHORT, NOT_HOLD
    }
    
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        var cache = new long[n][k + 1][State.values().length];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l < State.values().length; l++) {
                    cache[i][j][l] = -INF;
                }
            }
        }
        
        return backtrack(0, State.NOT_HOLD, k, prices, cache);
    }
    
    private long backtrack(int index, State state, int k, int[] prices, long[][][] cache) {
        if (index == prices.length) {
            return (k >= 0 && state == State.NOT_HOLD) ? 0 : -INF;
        }
        
        if (cache[index][k][state.ordinal()] != -INF) {
            return cache[index][k][state.ordinal()];
        }
        
        cache[index][k][state.ordinal()] = switch (state) {
            case HOLD_NORMAL -> Math.max(
                backtrack(index + 1, State.NOT_HOLD, k, prices, cache) + prices[index],
                backtrack(index + 1, State.HOLD_NORMAL, k, prices, cache)
            );
            case HOLD_SHORT -> Math.max(
                backtrack(index + 1, State.NOT_HOLD, k, prices, cache) - prices[index],
                backtrack(index + 1, State.HOLD_SHORT, k, prices, cache)
            );
            case NOT_HOLD -> Math.max(
                Math.max(
                    k > 0 ? backtrack(index + 1, State.HOLD_NORMAL, k - 1, prices, cache) - prices[index] : -INF,
                    k > 0 ? backtrack(index + 1, State.HOLD_SHORT, k - 1, prices, cache) + prices[index] : -INF
                ),
                backtrack(index + 1, State.NOT_HOLD, k, prices, cache)
            );
        };
        
        return cache[index][k][state.ordinal()];
    }
}