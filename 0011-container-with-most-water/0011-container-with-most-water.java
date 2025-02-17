class Solution {
    public int maxArea(int[] height) {
    int max = 0;
    int i = 0, j = height.length - 1;
    
    while (i < j) {
        int minHeight = Math.min(height[i], height[j]);
        max = Math.max(max, minHeight * (j - i));
    
        if (height[i] < height[j]) {
            i++;  
        } else {
            j--; 
        }
    }
    
    return max;
}

}