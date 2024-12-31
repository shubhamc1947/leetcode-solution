class Solution {
    //in case of overlapping , first rec bottom left < second rec top right and , second rec bottom rec < first rec top right 
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1=rec1[0],y1=rec1[1],x2=rec1[2],y2=rec1[3];
        int xa=rec2[0],ya=rec2[1],xb=rec2[2],yb=rec2[3];
        return x1<xb && y1<yb && xa<x2 && ya<y2;
    }
}