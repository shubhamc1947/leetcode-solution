class Solution {
    public int findClosest(int x, int y, int z) {
        int diffX=Math.abs(z-x);
        int diffY=Math.abs(z-y);
        if(diffX==diffY){
            return 0;
        }else if(diffX>diffY){
            return 2;
        }else{
            return 1;
        }
    }
}