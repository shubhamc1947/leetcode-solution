class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, placed = 0;
        boolean[] used = new boolean[n];  

        for (int f : fruits) {            
            for (int j = 0; j < n; j++) { 
                if (!used[j] && baskets[j] >= f) { 
                    used[j] = true;      
                    placed++;          
                    break;               
                }
            }
        }
        return n - placed;               

    }
}