class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        // If array has 1 or 2 fruits, all can be picked
        if(n == 1 || n == 2){
            return n;
        }

        int max = 2; // Initial max number of fruits
        int b1 = fruits[0]; // First basket type
        int b2 = -1;         // Second basket type (not yet assigned)
        int countB1 = 1;     // Count of fruits of type b1 in current window
        int countB2 = 0;     // Count of fruits of type b2 in current window
        int sum = 0;         // Total count of fruits in current valid window
        int i = 0;           // Left boundary of sliding window

        // Start iterating from the second fruit
        for(int j = 1; j < n; j++){
            int end = fruits[j]; // Current fruit at right end of the window

            if(end == b1){
                // If same as b1, increment its count
                countB1++;
            } else if(end == b2){
                // If same as b2, increment its count
                countB2++;
            } else if(countB1 == 0){
                // If b1's count is 0, assign b1 to current fruit
                b1 = end;
                countB1++;
            } else if(countB2 == 0){
                // If b2's count is 0, assign b2 to current fruit
                b2 = end;
                countB2++;
            } else {
                // A third fruit is found, need to shrink window from left
                while(countB1 != 0 && countB2 != 0){
                    int start = fruits[i]; // Fruit at the left end of window
                    if(start == b1){
                        countB1--; // Decrement b1 count
                    } else {
                        countB2--; // Decrement b2 count
                    }
                    i++; // Shrink window from left
                }

                // After shrinking, assign the new fruit to the emptied basket
                if(countB1 == 0){
                    b1 = end;
                    countB1 = 1;
                } else {
                    b2 = end;
                    countB2 = 1;
                }
            }

            // Calculate current window size and update max
            sum = countB1 + countB2;
            max = Math.max(max, sum);
        }

        return max; // Return the maximum fruits collected in any window
    }
}