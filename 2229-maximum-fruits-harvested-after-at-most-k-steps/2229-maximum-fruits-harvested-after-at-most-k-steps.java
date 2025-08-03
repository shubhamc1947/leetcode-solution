import java.util.Arrays; 
 
class Solution { 
    public int maxTotalFruits(int[][] fruits, int startPos, int k) { 
        int n = fruits.length; 
        if (n == 0) return 0; 
 
        int[] pSum = new int[n]; 
        int[] positions = new int[n]; 
        int currentSum = 0; 
        for (int i = 0; i<n; i++) { 
            positions[i] = fruits[i][0]; 
            currentSum += fruits[i][1]; 
            pSum[i] = currentSum; 
        } 
 
        int maxFruits = 0; 
        for (int d = 0; d <= k / 2; d++) { 
            // Case 1: Go LEFT first, then RIGHT 
            int leftBoundary1 = startPos - d; 
            int rightBoundary1 = startPos + (k - 2 * d); 
            maxFruits = Math.max(maxFruits, calculateFruits(positions, pSum, leftBoundary1, rightBoundary1)); 
 
            // Case 2: Go RIGHT first, then LEFT 
            int rightBoundary2 = startPos + d; 
            int leftBoundary2 = startPos - (k - 2 * d); 
            maxFruits = Math.max(maxFruits, calculateFruits(positions, pSum, leftBoundary2, rightBoundary2)); 
        } 
        return maxFruits; 
    } 
 
    public int calculateFruits(int[] positions, int[] pSum, int minPos, int maxPos) { 
         
        int startIndex = lowerBound(positions, minPos); 
        int endIndex = upperBound(positions, maxPos) - 1; 
 
        if (startIndex > endIndex) return 0; 
 
        int total = pSum[endIndex]; 
        if (startIndex > 0) { 
            total -= pSum[startIndex - 1]; 
        } 
        return total; 
    } 
 
    public int lowerBound(int[] arr, int x) { 
        int idx = Arrays.binarySearch(arr, x); 
        if (idx < 0) { 
            return -idx - 1; 
        } 
        while (idx > 0 && arr[idx - 1] == x) { 
            idx--; 
        } 
        return idx; 
    } 
 
    private int upperBound(int[] arr, int x) { 
        return lowerBound(arr, x + 1); 
    } 
} 