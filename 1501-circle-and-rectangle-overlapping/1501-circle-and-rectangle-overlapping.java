class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xNearest=Math.max(x1,Math.min(xCenter,x2));
        int yNearest=Math.max(y1,Math.min(yCenter,y2));
        int dx=xNearest-xCenter;
        int dy=yNearest-yCenter;
        return (dx*dx)+(dy*dy)<=radius*radius;
    }
}